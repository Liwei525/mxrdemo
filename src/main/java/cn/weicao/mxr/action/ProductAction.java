package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/product/*")
public class ProductAction extends AbstractAction {
	private static final String TITLE = "生产计划" ;
	@RequiresRoles("product")
	@RequiresPermissions("product:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("生产计划名称:name", super.getPage("product.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("product.list.page"));
		return mav;
	}
	@RequiresRoles("product")
	@RequiresPermissions("product:list")
	@RequestMapping("list_details")
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("product.list.details.page"));
		return mav;
	}
}
