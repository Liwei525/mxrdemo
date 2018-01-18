package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/warehousereplenish/*")
public class WarehouseReplenishAction extends AbstractAction{
	private static final String ACTION_TITLE = "仓储补货" ;
	@RequiresRoles("warehousereplenish")
	@RequiresPermissions("warehousereplenish:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("补货标题:title", super.getPage("warehousereplenish.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("warehousereplenish.list.page"));
		return mav;
	}
	@RequiresRoles("warehousereplenish")
	@RequiresPermissions("warehousereplenish:list")
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("warehousereplenish.list.details.page"));
		return mav;
	}
}
