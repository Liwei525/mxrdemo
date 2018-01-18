package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/productplanucgoods/*")
public class ProductPlanUCGoodsAction extends AbstractAction {
	private static final String TITLE = "生产计划原材料" ;
	@RequiresRoles("productplanucgoods")
	@RequiresPermissions("productplanucgoods:list")
	@RequestMapping("list") 
	public ModelAndView listDetails() {
		SplitPageUtil spu = new SplitPageUtil("计划名称:name|公司名称:cuid", super.getPage("productplanucgoods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("productplanucgoods.list.page"));
		return mav;
	}
	@RequiresRoles("productplanucgoods")
	@RequiresPermissions("productplanucgoods:edit")
	@RequestMapping("edit_pre") 
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("productplanucgoods.edit.page"));
		return mav;
	}
}
