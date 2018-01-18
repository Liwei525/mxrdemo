package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/cgoods/*")
public class CGoodsAction extends AbstractAction {
	private static final String TITLE = "成品" ;
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("cgoods.add.page"));
		return mav;
	}
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "cgoods.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:show")
	@RequestMapping("show")
	public ModelAndView show() { 
		ModelAndView mav = new ModelAndView(super.getPage("cgoods.show.page"));
		return mav;
	}
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre() { 
		ModelAndView mav = new ModelAndView(super.getPage("cgoods.edit.page"));
		return mav;
	} 
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "cgoods.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("成品编号:gid|成品名称:name", super.getPage("cgoods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("cgoods.list.page"));
		return mav;
	}
	@RequiresRoles("cgoods")
	@RequiresPermissions("cgoods:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("cgoods.list.details.page"));
		return mav;
	}
}
