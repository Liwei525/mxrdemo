package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/customer/*")
public class CustoumerAction extends AbstractAction {
	private static final String TITLE = "公司" ;
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("customer.add.page"));
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "customer.add.action", "vo.add.success", TITLE);
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(long cuid) {
		ModelAndView mav = new ModelAndView(super.getPage("customer.edit.page"));
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:edit")
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("公司名称:name|公司地址:address", super.getPage("customer.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("customer.list.page"));
		return mav;
	}
}
