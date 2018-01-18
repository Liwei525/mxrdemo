package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;

@Controller
@RequestMapping("/pages/back/admin/cgoodsmanage/*")
public class CGoodsManageAction extends AbstractAction {
	private static final String TITLE = "成品仓库管理" ;
	@RequiresRoles("cgoodsmanage")
	@RequiresPermissions("cgoodsmanage:output")
	@RequestMapping("output_input_pre")
	public ModelAndView storageInputPre() {
		ModelAndView mav = new ModelAndView(super.getPage("cgoodsmanage.output.input.page"));
		return mav;
	}
	@RequiresRoles("cgoodsmanage")
	@RequiresPermissions("cgoodsmanage:output")
	@RequestMapping("output_input")
	public ModelAndView storageInput() {
		ModelAndView mav = new ModelAndView(super.getPage("cgoodsmanage.output.page"));
		return mav;
	}
}
