package cn.weicao.mxr.realm;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.weicao.mxr.service.IDeptService;
import cn.weicao.mxr.service.IEmpService;
import cn.weicao.mxr.vo.Emp;

public class EmpRealm extends AuthorizingRealm {
	@Resource
	private IEmpService	empService ;
	@Resource
	private IDeptService deptService ;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.err.println("================== 2、进行用户授权处理操作（doGetAuthorizationInfo()）=================");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
		String eid = (String) principals.getPrimaryPrincipal() ;
		Map<String,Set<String>> map = this.empService.getRolesAndAction(eid) ;
		info.setRoles(map.get("allRoles"));
		info.setStringPermissions(map.get("allActions"));
		return info ;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("================= 1、进行用户认证处理操作（doGetAuthenticationInfo()）=================");
		String eid = (String) token.getPrincipal() ;
		Emp emp = this.empService.get(eid) ;
		if(emp == null || !emp.getEid().equals(this.deptService.get(emp.getDid()).getEid())) {
			throw new UnknownAccountException("账号‘ " + eid + " ’不存在。") ;
		}
//		String password = PasswordUtil.encoder(new String((char[])token.getCredentials())) ;
//		if(!member.getPassword().equals(password)) {
//			throw new IncorrectCredentialsException("错误的用户名或密码！") ;
//		}
		return new SimpleAuthenticationInfo(token.getPrincipal(),emp.getPassword(),"empRealm") ;
	}
	

}

