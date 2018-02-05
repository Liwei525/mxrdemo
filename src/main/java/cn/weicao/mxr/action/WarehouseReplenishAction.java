package cn.weicao.mxr.action;

import java.util.Date ;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IReplenishApplyService;
import cn.weicao.mxr.service.IWarehouseReplenishService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.ReplenishApply;

@Controller
@RequestMapping("/pages/back/admin/warehousereplenish/*")
public class WarehouseReplenishAction extends AbstractAction{
	private static final String TITLE = "仓储补货" ;
	@Resource
	private IWarehouseReplenishService warehouseReplenishService ;
	@Resource
	private IReplenishApplyService replenishApplyService ;
	@RequiresRoles("warehousereplenish")
	@RequiresPermissions("warehousereplenish:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("补货单号:raid|补货标题:title", super.getPage("warehousereplenish.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("warehousereplenish.list.page"));
		mav.addAllObjects(this.warehouseReplenishService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("warehousereplenish")
	@RequiresPermissions("warehousereplenish:list")
	@RequestMapping("list_details") 
	public ModelAndView listDetails(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("warehousereplenish.list.details.page"));
		mav.addAllObjects(this.warehouseReplenishService.listDetails(raid)) ;
		return mav;
	}
	@RequiresRoles("warehousereplenish")
	@RequiresPermissions("warehousereplenish:list")
	@RequestMapping("submit") 
	public ModelAndView submit(int raid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		ReplenishApply replenishApply = this.replenishApplyService.get(raid) ;
		if(replenishApply == null || replenishApply.getStatus() != 1 || replenishApply.getFlag() == 0 ) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url",super.getPage("warehousereplenish.list.action")) ;
		}else {
			replenishApply.setWatchDate(new Date());
			replenishApply.setWatchMid(super.loginMid());
			replenishApply.setStatus(2);
			if(this.warehouseReplenishService.submit(replenishApply)) {
				super.setMsgAndUrl(mav, "warehousereplenish.list.action", "vo.submit.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "warehousereplenish.list.action", "vo.submit.failure", TITLE);
			}
		}
		return mav;
	}
}
