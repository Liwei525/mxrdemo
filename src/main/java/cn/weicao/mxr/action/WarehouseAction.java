package cn.weicao.mxr.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IWarehouseService;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/warehouse/*")
public class WarehouseAction extends AbstractAction {
	private static final String TITLE = "仓库" ;
	@Resource
	private IWarehouseService warehouseService ;
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.add.page"));
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "warehouse.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(long wid) {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.edit.page"));
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("仓库名称:name|仓库地址:address", super.getPage("warehouse.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.list.page"));
		return mav;
	}
	@RequestMapping("show_info")
	@ResponseBody
	public Object showInfo(int wid) {
		return this.warehouseService.get(wid) ; 
	}
}
