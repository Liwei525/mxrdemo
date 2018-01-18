package cn.weicao.mxr.filter;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.weicao.mxr.util.cache.RedisCache;

public class KickoutSessionControlFilter extends AccessControlFilter{
	private String kickoutUrl ;
	// kickoutAfter = true 表示踢出之后的
	// kickoutAfter = false 表示踢出之前的
	private boolean kickoutAfter = false ;
	private int maxSessionCount = 1 ;
	private SessionManager sessionManager ;
	private Cache<Object,Object> cache ;
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		return false ;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = super.getSubject(request, response) ;
		if(!subject.isAuthenticated() && !subject.isRemembered()) {
			request.getRequestDispatcher("/loginForm.action").forward(request, response);
			return false ;
		}
		Session session = subject.getSession() ;
		String mid = (String) subject.getPrincipal() ;
		Deque<Serializable> allSessions = (Deque<Serializable>)this.cache.get(mid) ;
		if(allSessions == null) {
			allSessions = new LinkedList<Serializable>() ;
		}
		if(!allSessions.contains(session.getId()) && session.getAttribute("kickout") == null) {
			allSessions.push(session.getId());
			this.cache.put(mid, allSessions) ;
		}
		try {
			if(allSessions.size() > this.maxSessionCount) {
				Serializable kickoutSessionId = null ;
				if(this.kickoutAfter) {
					kickoutSessionId = allSessions.removeFirst() ;
				}else {
					kickoutSessionId = allSessions.removeLast() ;
				}
				Session kickoutSession = this.sessionManager.getSession(new DefaultSessionKey(kickoutSessionId)) ;
				if(kickoutSession != null) {
					kickoutSession.setAttribute("kickout", true);
					this.cache.put(mid, allSessions) ;
				}
			}
		}catch(Exception e) {
			this.cache.put(mid, allSessions) ;
		}
		if(session.getAttribute("kickout") != null) {
			try {
				subject.logout();
				this.cache.put(mid, allSessions) ;
			}catch(Exception e) {}
			super.saveRequest(request);
			WebUtils.issueRedirect(request, response, this.kickoutUrl + "?kickmsg=out");
			return false ;
		}
		return true ;
	}
	public void setMaxSessionCount(int maxSessionCount) {
		this.maxSessionCount = maxSessionCount ;
	}
	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager ;
	}
	public void setKickoutAfter(boolean kickoutAfter) {
		this.kickoutAfter = kickoutAfter ;
	}
	public void setKickoutUrl(String kickoutUrl) {
		this.kickoutUrl = kickoutUrl ;
	}
	public void setCacheManager(CacheManager cacheManager) {
		this.cache = (RedisCache<Object,Object>) cacheManager.getCache("kickout") ;
	}
}
