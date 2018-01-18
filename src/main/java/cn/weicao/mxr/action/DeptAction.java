package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;

@Controller
@RequestMapping("/pages/back/admin/dept/*")
public class DeptAction extends AbstractAction{
	private static final String ACTION_TITLE = "部门" ;
	@RequiresRoles("dept")
	@RequiresPermissions("dept:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.add.page"));
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.list.page"));
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:edit")
	@RequestMapping("edit_pre") 
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.edit.page"));
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.list.details.page"));
		return mav;
	}
}
