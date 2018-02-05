package cn.weicao.mxr.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IReplenishApplyService;
import cn.weicao.mxr.service.IUCGoodsStorageApplyService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.ReplenishApply;
import cn.weicao.mxr.vo.UCGoodsStorageApply;

@Controller
@RequestMapping("/pages/back/admin/replenishapplication/*")
public class ReplenishApplicationAction extends AbstractAction {
	private static final String TITLE = "补货申请" ;
	@Resource
	private IReplenishApplyService replenishApplyService ;
	@Resource
	private IUCGoodsStorageApplyService ucgoodsStorageApplyService ;
	
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.add.page"));
		mav.addObject("allProvinces", replenishApplyService.addPre()) ;
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("get_city")
	@ResponseBody
	public Object getCity(int pid) {
		return this.ucgoodsStorageApplyService.getCity(pid) ;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("get_warehouse")
	@ResponseBody
	public Object getWarehouse(int pid,int cid) {
		return this.ucgoodsStorageApplyService.getWarehouse(pid, cid) ;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:add")
	@RequestMapping("add")
	public ModelAndView add(ReplenishApply replenishApply) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		replenishApply.setAppDate(new Date());
		replenishApply.setAppMid(super.loginMid());
		replenishApply.setFlag(1);
		replenishApply.setStatus(0);
		if(this.replenishApplyService.add(replenishApply)) {
			super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.add.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "replenishapplication.add.pre.action", "vo.add.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("补货单号:raid|补货标题:name", super.getPage("replenishapplication.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.list.page"));
		mav.addAllObjects(this.replenishApplyService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.edit.page"));
		ReplenishApply replenishApply = this.replenishApplyService.get(raid) ;
		if(replenishApply == null) {
		}else {
			mav.addAllObjects(this.replenishApplyService.editPre(raid)) ;
		}
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("edit")
	public ModelAndView edit(ReplenishApply replenishApply) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		ReplenishApply oldReplenishApply = this.replenishApplyService.get(replenishApply.getRaid()) ;
		if(oldReplenishApply == null || oldReplenishApply.getStatus() != 0) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url", super.getPage("replenishapplication.list.action")) ;
		}else {
			replenishApply.setAppDate(new Date());
			replenishApply.setAppMid(loginMid());
			replenishApply.setFlag(1);
			replenishApply.setStatus(0);
			if(this.replenishApplyService.edit(replenishApply)) {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.edit.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.edit.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("remove")
	public ModelAndView remove(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		ReplenishApply replenishApply = this.replenishApplyService.get(raid) ;
		if(replenishApply == null || replenishApply.getStatus() != 0 || replenishApply.getFlag() != 1) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url", super.getPage("replenishapplication.list.action")) ;
		}else {
			if(this.replenishApplyService.remove(raid)) {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.delete.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.delete.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("list_details") 
	public ModelAndView listDetails(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("replenishapplication.list.details.page"));
		mav.addAllObjects(this.replenishApplyService.listDetails(raid)) ;
		return mav;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("add_ucgoods") 
	@ResponseBody
	public Object addUCGoods(String raid,String ucid,int amount) {
		return this.replenishApplyService.addUCGoods(raid, ucid, amount) ;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("remove_ucgoods") 
	@ResponseBody
	public Object removeUCGoods(String raid,String ucid) {
		return this.replenishApplyService.removeUCGoods(raid, ucid) ;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("ucgoods_like") 
	@ResponseBody
	public Object ucgoodsLike(String raid,String keyWord) {
		return this.replenishApplyService.ucgoodsLike(raid,keyWord) ;
	}
	@RequiresRoles("replenishapplication")
	@RequiresPermissions("replenishapplication:edit")
	@RequestMapping("submit") 
	public ModelAndView submit(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		ReplenishApply replenishApply = this.replenishApplyService.get(raid) ;
		if(replenishApply.getStatus() != 0) {
			super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.submit.failure", TITLE);
		}else {
			replenishApply.setStatus(1);
			replenishApply.setSendMid(super.loginMid());
			replenishApply.setSendDate(new Date());
			if(this.replenishApplyService.submit(replenishApply)) {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.submit.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "replenishapplication.list.action", "vo.submit.failure", TITLE);
			}
		}
		return mav;
	}
}
