package cn.weicao.mxr.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;

@Controller
public class PageAction extends AbstractAction{
	@ResponseBody
	@RequestMapping("/check_rand")
	public Object check(String code) {
		String rand = (String) super.getRequest().getSession().getAttribute("rand") ;
		if (rand == null || "".equals(rand)) {
			return false ;
		} else {
			return rand.equalsIgnoreCase(code);
		}
	}
	@RequestMapping("/loginForm")
	public String loginPre() {
		return "login" ;                         
	}
//	@RequestMapping("/login")
//	public String login(String eid,String password,HttpServletRequest request) {
//		AuthenticationToken token = new UsernamePasswordToken(eid,password) ;
//		try {
//			SecurityUtils.getSubject().login(token);
//			return "back/welcome" ;
//		}catch(Exception e) {
//			request.setAttribute("error", e.getMessage());
//			return "login" ;
//		}
//	}
	@RequestMapping("/pages/back/index")
	public String welcome() {
		return "back/index" ;
	}
	@RequestMapping("logout")
	public String logout() {
		return "login" ;
	}
	@ResponseBody
	@RequestMapping("/unauth")
	public Object unauth() {
		return "【ERROR - AUTH】没有此类处理权限 " ;
	}
	@RequestMapping("/back_error")
	public Object backError() {
		ModelAndView mav = new ModelAndView(super.getPage("error.page"));
		return mav;
	}
	
}

