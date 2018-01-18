package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/replenishapplication/*")
public class ReplenishApplicationAction extends AbstractAction {
	private static final String TITLE = "补货申请" ;
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.add.page"));
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "replenishapplication.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.edit.page"));
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.list.details.page"));
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("补货标题:title", super.getPage("replenishapplication.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.list.page"));
		return mav;
	}
}
