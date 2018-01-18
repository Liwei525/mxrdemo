package cn.weicao.mxr.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsstorageaudit/*")
public class UCGoodsStorageAuditAction extends AbstractAction {
	private static final String TITLE = "半成品入库审核" ;
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:list")
	@RequestMapping("list_prepare") 
	public ModelAndView listDetails() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", super.getPage("ucgoodsstorage.audit.list.prepare.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.list.prepare.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:edit")
	@RequestMapping("edit_pre") 
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.edit.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:list")
	@RequestMapping("list_history") 
	public ModelAndView listHistory() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", super.getPage("ucgoodsstorage.audit.list.history.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.list.history.page"));
		return mav;
	}
}
