package cn.weicao.mxr.action;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IEmpService;
import cn.weicao.mxr.util.PasswordUtil;

@Controller
@RequestMapping("/pages/back/admin/myself/*")
public class MyselfAction extends AbstractAction{
	@Resource
	private IEmpService empService ;
	@RequestMapping("update_password_pre")
	public ModelAndView updatePasswordPre() {
		ModelAndView mav = new ModelAndView(super.getPage("update.password.pre.page"));
		return mav;
	}
	@RequestMapping("update_password")
	public ModelAndView updatePassword(String oldPassword,String newPassword,String repeatPassword) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		String eid = (String)SecurityUtils.getSubject().getPrincipal() ;
		if(newPassword.equals(repeatPassword)) {
			if(this.empService.get(eid).getPassword().equals(PasswordUtil.encoder(oldPassword))) {
				if(this.empService.editPassword(eid, PasswordUtil.encoder(newPassword))) {
					mav.addObject("msg", "密码修改成功！") ;
					mav.addObject("url",super.getPage("index.action")) ;
				}else {
					mav.addObject("msg", "密码修改失败！") ;
					mav.addObject("url",super.getPage("update.password.pre.action")) ;
				}
			}else {
				mav.addObject("msg", "原始密码不正确！") ;
				mav.addObject("url",super.getPage("update.password.pre.action")) ;
			}
		}else {
			mav.addObject("msg", "两次输入的密码不一致！") ;
			mav.addObject("url",super.getPage("update.password.pre.action")) ;
		}
		return mav;
	}
	@RequestMapping("show_myself")
	public ModelAndView showMyself() {
		ModelAndView mav = new ModelAndView(super.getPage("show.myself.page"));
		String eid = (String)SecurityUtils.getSubject().getPrincipal() ;
		mav.addAllObjects(this.empService.getMyself(eid)) ;
		return mav;
	}
}
