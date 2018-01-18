package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/plant/*")
public class PlantAction extends AbstractAction{
	private static final String TITLE = "车间" ;
	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("plant.add.page"));
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "plant.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("plant.edit.page"));
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("车间名称:pname|车间电话:phone", super.getPage("plant.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("plant.list.page"));
		return mav;
	}
}
