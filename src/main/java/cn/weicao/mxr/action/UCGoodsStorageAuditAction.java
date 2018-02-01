package cn.weicao.mxr.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IUCGoodsStorageApplyService;
import cn.weicao.mxr.service.IUCGoodsStorageAuditService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.UCGoodsStorageApply;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsstorageaudit/*")
public class UCGoodsStorageAuditAction extends AbstractAction {
	private static final String TITLE = "半成品入库审核" ;
	@Resource
	private IUCGoodsStorageAuditService ucgoodsStorageAuditService ;
	@Resource
	private IUCGoodsStorageApplyService ucgoodsStorageApplyService ;
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:list")
	@RequestMapping("list_prepare") 
	public ModelAndView listDetails() {
		SplitPageUtil spu = new SplitPageUtil("合同号:usaid|申请标题:title|拼音码:pinyin", super.getPage("ucgoodsstorage.audit.list.prepare.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.list.prepare.page"));
		mav.addAllObjects(this.ucgoodsStorageAuditService.listPrepare(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:list")
	@RequestMapping("apply_details") 
	@ResponseBody
	public Object applyDetails(String usaid,int jsCommonCp,int jsCommonLs) {
		return this.ucgoodsStorageAuditService.applyDetails(usaid, jsCommonCp, jsCommonLs) ;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:edit")
	@RequestMapping("edit_pre") 
	public ModelAndView editPre(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.edit.page"));
		mav.addAllObjects(this.ucgoodsStorageAuditService.editPre(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:edit")
	@RequestMapping("edit") 
	public ModelAndView edit(String usaid,int audit,String note) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyService.get(usaid) ;
		if(ucgoodsStorageApply.getStatus() == 1) {
			if(this.ucgoodsStorageAuditService.edit(usaid, audit, note, super.loginMid())) {
				super.setMsgAndUrl(mav, "ucgoodsstorage.audit.list.prepare.action", "vo.submit.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "ucgoodsstorage.audit.list.prepare.action", "vo.submit.failure", TITLE);
			}
		}else {
			super.setMsgAndUrl(mav, "ucgoodsstorage.audit.list.prepare.action", "vo.submit.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("ucgoodsstorageaudit")
	@RequiresPermissions("ucgoodsstorageaudit:list")
	@RequestMapping("list_history") 
	public ModelAndView listHistory() {
		SplitPageUtil spu = new SplitPageUtil("合同号:usaid|申请标题:title|拼音码:pinyin", super.getPage("ucgoodsstorage.audit.list.history.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.audit.list.history.page"));
		mav.addAllObjects(this.ucgoodsStorageAuditService.listHistory(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
}
