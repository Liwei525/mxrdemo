package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/productplan/*")
public class ProductPlanAction extends AbstractAction {
	private static final String TITLE = "生产计划" ;
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("productplan.add.page"));
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "productplan.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("productplan.edit.page"));
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "productplan.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("生产计划名称:name", super.getPage("productplan.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("productplan.list.page"));
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:list")
	@RequestMapping("list_details")
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("productplan.list.details.page"));
		return mav;
	}
	@RequiresRoles("productplan")
	@RequiresPermissions("productplan:send")
	@RequestMapping("send")
	public ModelAndView send() {
		ModelAndView mav = new ModelAndView(super.getPage("productplan.send.page"));
		return mav;
	}
}
