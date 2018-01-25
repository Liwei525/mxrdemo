package cn.weicao.mxr.action;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IUCGoodsService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.UCGoods;

@Controller
@RequestMapping("/pages/back/admin/ucgoods/*")
public class UCGoodsAction extends AbstractAction {
	private static final String TITLE = "半成品" ;
	@Resource
	private IUCGoodsService ucgoodsService ;
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.add.page"));
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("check_name")
	@ResponseBody
	public Object checkName(String name) {
		return this.ucgoodsService.getByName(name) == null ? true : false ;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("add")
	public ModelAndView add(UCGoods ucgoods,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		ucgoods.setStornum(0);
		ucgoods.setRecorder(super.loginMid());
		ucgoods.setFlag(1);
		String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
		String photo = "upload/ucgoods/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
		ucgoods.setPhoto(photo);
		if(this.ucgoodsService.add(ucgoods)) {
			try {
				pic.transferTo(new File(file + photo));
				super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.add.success", TITLE);
			}catch(Exception e) {
				super.setMsgAndUrl(mav, "ucgoods.add.pre.action", "vo.add.failure", TITLE);
			}
		}else {
			super.setMsgAndUrl(mav, "ucgoods.add.pre.action", "vo.add.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("半成品编号:ucid|半成品名称:name", super.getPage("ucgoods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.list.page"));
		mav.addAllObjects(this.ucgoodsService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(int ucid) { 
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.edit.page"));
		UCGoods ucgoods = this.ucgoodsService.get(ucid) ;
		if(ucgoods == null) {
			mav.addObject("errors", "不存在该半成品！") ;
		}else {
			mav.addObject("ucgoods", ucgoods) ;
		}
		return mav;
	} 
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:add")
	@RequestMapping("check_name_myself")
	@ResponseBody
	public Object checkNameMyself(int ucid,String name) {
		UCGoods ucgoods = this.ucgoodsService.get(ucid) ;
		if(name.equals(ucgoods.getName())) {
			return true ;
		}else {
			return this.ucgoodsService.getByName(name) == null ? true : false ;
		}
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:edit")
	@RequestMapping("edit")
	public ModelAndView edit(UCGoods ucgoods,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		UCGoods olducgoods = this.ucgoodsService.get(ucgoods.getUcid()) ;
		if(olducgoods.getFlag() == 0) {
			super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.failure", TITLE);
		} else {
			ucgoods.setLastin(olducgoods.getLastin());
			ucgoods.setStornum(olducgoods.getStornum());
			ucgoods.setFlag(1);
			ucgoods.setRecorder(super.loginMid());
			if(pic.getSize() != 0) {
				String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
				String photo = "upload/ucgoods/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
				ucgoods.setPhoto(photo);
				if(this.ucgoodsService.edit(ucgoods)) {
					try {
						pic.transferTo(new File(file + photo));
						super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.success", TITLE);
					} catch (Exception e) {
						super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.failure", TITLE);
					}
				}else {
					super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.failure", TITLE);
				}
			}else {
				if(this.ucgoodsService.edit(ucgoods)) {
					super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "ucgoods.list.action", "vo.edit.failure", TITLE);
				}
			}
		}
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:show")
	@RequestMapping("show")
	public ModelAndView show(int ucid) { 
		ModelAndView mav = new ModelAndView(super.getPage("ucgoods.show.page"));
		UCGoods ucgoods = (UCGoods)this.ucgoodsService.show(ucid).get("ucgoods") ;
		if(ucgoods == null) {
			mav.addObject("errors", "不存在该半成品！") ;
		}else {
			mav.addAllObjects(this.ucgoodsService.show(ucid)) ;
		}
		return mav;
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:show")
	@RequestMapping("show_storage_details")
	@ResponseBody
	public Object showStorageDetails(int ucid) { 
		return this.ucgoodsService.showStorageDetails(ucid);
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:show")
	@RequestMapping("show_output_details")
	@ResponseBody
	public Object showOutputDetails(int ucid) { 
		return this.ucgoodsService.showOutputDetails(ucid);
	}
	@RequiresRoles("ucgoods")
	@RequiresPermissions("ucgoods:show")
	@RequestMapping("num_details")
	@ResponseBody
	public Object numDetails(int ucid) { 
		return this.ucgoodsService.ucgoodsNumDetails(ucid);
	}
}
