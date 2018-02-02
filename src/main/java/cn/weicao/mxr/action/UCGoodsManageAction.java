package cn.weicao.mxr.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IUCGoodsManageService;
import cn.weicao.mxr.service.IUCGoodsStorageApplyService;
import cn.weicao.mxr.service.IUCGoodsStorageApplyWarehouseService;
import cn.weicao.mxr.vo.UCGoodsStorageApply;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsmanage/*")
public class UCGoodsManageAction extends AbstractAction {
	/*private static final String TITLE = "半成品仓库管理" ;*/
	@Resource
	private IUCGoodsManageService ucgoodsManageService ;
	@Resource
	private IUCGoodsStorageApplyService ucgoodsStorageApplyService ;
	@Resource
	private IUCGoodsStorageApplyWarehouseService ucgoodsStorageApplyWarehouseService ;
	
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("storage_input_pre")
	public ModelAndView storageInputPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsmanage.storage.input.page"));
		return mav;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("usaid_like")
	@ResponseBody
	public Object usaidLike(String keyWord) {
		return this.ucgoodsManageService.usaidLike(keyWord) ;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("storage_input")
	public ModelAndView storageInput(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsmanage.storage.page"));
		mav.addAllObjects(this.ucgoodsManageService.storageDetails(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("check_usawid")
	@ResponseBody
	public Object checkUsawid(String usawid) {
		return this.ucgoodsStorageApplyWarehouseService.get(usawid) == null ;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("usawid_save")
	@ResponseBody
	public Object usawidSave(String usaid,String usawid,String note) {
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyService.get(usaid) ;
		if(ucgoodsStorageApply.getStatus() != 3) {
			return false ;
		}
		return this.ucgoodsManageService.usawidSave(usaid,usawid,note,super.loginMid()) ;
	}
	@RequiresRoles("ucgoodsmanage")
	@RequiresPermissions("ucgoodsmanage:storage")
	@RequestMapping("ucid_save")
	@ResponseBody
	public Object ucidSave(String usaid,String usawid,int ucid,int num) {
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyService.get(usaid) ;
		if(ucgoodsStorageApply.getStatus() != 3) {
			return false ;
		}
		return this.ucgoodsManageService.ucidSave(usaid, usawid, ucid, num) ;
	}
}
