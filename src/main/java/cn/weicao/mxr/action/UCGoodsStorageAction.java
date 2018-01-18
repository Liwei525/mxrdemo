package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsstorage/*")
public class UCGoodsStorageAction extends AbstractAction {
	private static final String TITLE = "半成品入库" ;
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.add.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "ucgoodsstorage.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.edit.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.list.details.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("list_myself") 
	public ModelAndView listMyself() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", super.getPage("ucgoodsstorage.list.myself.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.list.myself.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("ucgsid_show") 
	public ModelAndView ucgsidShow() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.ucgsid.show.page"));
		return mav;
	}
}
