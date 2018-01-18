package cn.weicao.mxr.util;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;

import cn.weicao.mxr.service.IEmpService;
import cn.weicao.mxr.util.cache.RedisCache;

public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher{
	@Resource
	private IEmpService empService ;
	private RedisCache<Object,Object> cache ;
	private String expire = "50" ;
	private int maxRetryCount = 5 ;
	private void retry(String eid) {
		AtomicInteger num = (AtomicInteger) this.cache.get(eid) ;
		if(num == null) {
			num = new AtomicInteger(1) ;
			this.cache.put(eid, num) ;
		}
		if(num.incrementAndGet() > this.maxRetryCount) {
			this.cache.putEx(eid, this.expire, num) ;
			throw new ExcessiveAttemptsException("用户“" + eid + "”密码尝试次数过多，请稍等再试！") ;
		}else {
			this.cache.put(eid, num) ;
		}
	}
	private void unlock(String eid) {
		this.cache.remove(eid) ;
	}
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String eid = (String) token.getPrincipal() ;
		this.retry(eid);
		Object tokenCredentials = PasswordUtil.encoder(super.toString(getCredentials(token)));
        Object accountCredentials = super.getCredentials(info);
        boolean flag = super.equals(tokenCredentials, accountCredentials) ;
        if(flag) {
        	this.unlock(eid);
    		SecurityUtils.getSubject().getSession().setAttribute("emp", this.empService.get(eid)) ;
    		this.empService.editLastDate(eid) ;
        }
        return flag;
	}
	public void setExpire(String expire) {
		this.expire = expire ;
	}
	public void setMaxRetryCount(int maxRetryCount) {
		this.maxRetryCount = maxRetryCount ;
	}
	public void setCacheManager(CacheManager cacheManager) {
		this.cache = (RedisCache<Object,Object>)cacheManager.getCache("retryCount") ;
	}
}
