package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractAction{
	private static final String TITLE = "雇员" ;
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("emp.add.page"));
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "emp.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("emp.edit.page"));
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("雇员姓名:ename|联系电话:phone|是否离职:state", super.getPage("emp.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("emp.list.page"));
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:state")
	@RequestMapping("state_pre")
	public ModelAndView statePre(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("emp.state.page"));
		return mav;
	}
}
