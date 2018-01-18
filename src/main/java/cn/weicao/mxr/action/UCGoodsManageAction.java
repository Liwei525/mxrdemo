package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsmanage/*")
public class UCGoodsManageAction extends AbstractAction {
	private static final String TITLE = "半成品仓库管理" ;
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("storage_input_pre")
	public ModelAndView storageInputPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsmanage.storage.input.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("storage_input")
	public ModelAndView storageInput() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsmanage.storage.page"));
		return mav;
	}
}
