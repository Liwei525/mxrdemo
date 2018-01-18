package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/ucgoods/*")
public class UCGoodsAction extends AbstractAction {
	private static final String TITLE = "半成品" ;
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.add.page"));
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "ucgoods.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:show")
	@RequestMapping("show")
	public ModelAndView show() { 
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.show.page"));
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre() { 
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.edit.page"));
		return mav;
	} 
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("半成品编号:gid|半成品名称:name", super.getPage("ucgoods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.list.page"));
		return mav;
	}
}
