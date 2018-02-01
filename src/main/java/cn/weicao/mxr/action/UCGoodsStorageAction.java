package cn.weicao.mxr.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IUCGoodsStorageApplyService;
import cn.weicao.mxr.util.PinyinUtils;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.UCGoodsStorageApply;

@Controller
@RequestMapping("/pages/back/admin/ucgoodsstorage/*")
public class UCGoodsStorageAction extends AbstractAction {
	private static final String TITLE = "半成品入库" ;
	@Resource
	private IUCGoodsStorageApplyService ucgoodsStorageApplyService ;
	@Resource
	private RedisTemplate<String, Integer> redisTemplate ;
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.add.page"));
		mav.addObject("allProvinces", this.ucgoodsStorageApplyService.addPre()) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("get_city")
	@ResponseBody
	public Object getCity(int pid) {
		return this.ucgoodsStorageApplyService.getCity(pid) ;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("get_warehouse")
	@ResponseBody
	public Object getWarehouse(int pid,int cid) {
		return this.ucgoodsStorageApplyService.getWarehouse(pid, cid) ;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("check_usaid")
	@ResponseBody
	public Object checkUsaid(String usaid) {
		if(this.ucgoodsStorageApplyService.get(usaid) == null) {
			return true ;
		}else {
			return false ;
		}
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:add")
	@RequestMapping("add")
	public ModelAndView add(UCGoodsStorageApply ucgoodsStorageApply) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if((boolean)this.checkUsaid(ucgoodsStorageApply.getUsaid()) == false) {
			mav.addObject("msg", "该合同号已存在！") ;
			mav.addObject("url",super.getPage("ucgoodsstorage.list.action")) ;
		}else {
			ucgoodsStorageApply.setStatus(0);
			ucgoodsStorageApply.setAppMid(super.loginMid());
			ucgoodsStorageApply.setAppDate(new Date());
			ucgoodsStorageApply.setPinyin(PinyinUtils.chineseToPinYinS(ucgoodsStorageApply.getTitle()).toLowerCase());
			if(this.ucgoodsStorageApplyService.add(ucgoodsStorageApply)) {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.add.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.add.failure", TITLE);
			}
		}
		
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title|拼音码:pinyin", super.getPage("ucgoodsstorage.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.list.page"));
		mav.addAllObjects(this.ucgoodsStorageApplyService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.edit.page"));
		mav.addAllObjects(this.ucgoodsStorageApplyService.editPre(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("edit")
	public ModelAndView edit(UCGoodsStorageApply ucgoodsStorageApply) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		UCGoodsStorageApply oldUCGoodsStorageApply = this.ucgoodsStorageApplyService.get(ucgoodsStorageApply.getUsaid()) ;
		ucgoodsStorageApply.setStatus(0);
		ucgoodsStorageApply.setPinyin(PinyinUtils.chineseToPinYinS(ucgoodsStorageApply.getTitle()).toLowerCase());
		ucgoodsStorageApply.setAppMid(oldUCGoodsStorageApply.getAppMid());
		ucgoodsStorageApply.setAppDate(oldUCGoodsStorageApply.getAppDate());
		ucgoodsStorageApply.setAuditMid(oldUCGoodsStorageApply.getAuditMid());
		ucgoodsStorageApply.setAuditDate(oldUCGoodsStorageApply.getAuditDate());
		ucgoodsStorageApply.setAuditNote(oldUCGoodsStorageApply.getAuditNote());
		if(this.ucgoodsStorageApplyService.edit(ucgoodsStorageApply)) {
			super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.edit.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.edit.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.list.details.page"));
		mav.addAllObjects(this.ucgoodsStorageApplyService.listDetails(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("add_ucgoods") 
	@ResponseBody
	public Object addUCGoods(String usaid,String ucid,int amount) {
		return this.ucgoodsStorageApplyService.addUCGoods(usaid, ucid, amount) ;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("remove_ucgoods") 
	@ResponseBody
	public Object removeUCGoods(String usaid,String ucid) {
		return this.ucgoodsStorageApplyService.removeUCGoods(usaid, ucid) ;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:edit")
	@RequestMapping("ucgoods_like") 
	@ResponseBody
	public Object ucgoodsLike(String usaid,String keyWord) {
		return this.ucgoodsStorageApplyService.ucgoodsLike(usaid,keyWord) ;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("submit") 
	public ModelAndView submit(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyService.get(usaid) ;
		if(ucgoodsStorageApply.getStatus() != 0 && ucgoodsStorageApply.getStatus() != 2) {
			super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.submit.failure", TITLE);
		}else {
			ucgoodsStorageApply.setStatus(1);
			ucgoodsStorageApply.setSendMid(super.loginMid());
			ucgoodsStorageApply.setSendDate(new Date());
			if(this.ucgoodsStorageApplyService.submit(ucgoodsStorageApply)) {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.submit.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.submit.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("remove") 
	public ModelAndView remove(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		UCGoodsStorageApply ucgoodsStorageApply = this.ucgoodsStorageApplyService.get(usaid) ;
		if(ucgoodsStorageApply.getStatus() == 0) {
			if(this.ucgoodsStorageApplyService.remove(usaid)) {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.delete.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.delete.failure", TITLE);
			}
		}else {
			super.setMsgAndUrl(mav, "ucgoodsstorage.list.action", "vo.delete.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("trail") 
	public ModelAndView trail(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.trail.page"));
		mav.addAllObjects(this.ucgoodsStorageApplyService.trail(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("usawid_show") 
	public ModelAndView usaidShow(String usaid) {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoodsstorage.usawid.show.page"));
		mav.addAllObjects(this.ucgoodsStorageApplyService.usawidShow(usaid)) ;
		return mav;
	}
	@RequiresRoles("ucgoodsstorage")
	@RequiresPermissions("ucgoodsstorage:list")
	@RequestMapping("usawid_details") 
	@ResponseBody
	public Object usaidDetails(String usawid,int jsCommonCp,int jsCommonLs) {
		return this.ucgoodsStorageApplyService.usawidDetails(usawid, jsCommonCp, jsCommonLs) ;
	}
}
