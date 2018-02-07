package cn.weicao.mxr.action;

import java.io.File;
import java.util.Date;
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
import cn.weicao.mxr.service.IPlantService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.Customer;
import cn.weicao.mxr.vo.Plant;

@Controller
@RequestMapping("/pages/back/admin/plant/*")
public class PlantAction extends AbstractAction{
	private static final String TITLE = "车间" ;
	@Resource
	private IPlantService plantService ;

	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("plant.add.page"));
		mav.addObject("allProvinces", this.plantService.addPre()) ;
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("get_city")
	@ResponseBody
	public Object getCity(int pid) {
		return this.plantService.getCity(pid) ;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("check_name")
	@ResponseBody
	public Object checkName(String name) {
		return this.plantService.get(name) == null ;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:add")
	@RequestMapping("add")
	public ModelAndView add(Plant plant,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if((boolean)this.checkName(plant.getName()) == false) {
			mav.addObject("msg", "该车间名称已存在！") ;
			mav.addObject("url",super.getPage("plant.list.action")) ;
		}else {
			plant.setFlag(1);
			plant.setIndate(new Date());
			plant.setRecorder(super.loginMid());
			String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
			String photo = "upload/plant/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			plant.setPhoto(photo);
			if(this.plantService.add(plant)) {
				try {
					pic.transferTo(new File(file + photo));
					super.setMsgAndUrl(mav, "plant.list.action", "vo.add.success", TITLE);
				} catch (Exception e) {
					super.setMsgAndUrl(mav, "plant.list.action", "vo.add.failure", TITLE);
				}
			}else {
				super.setMsgAndUrl(mav, "plant.list.action", "vo.add.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("车间编号:plid|车间名称:pname|地址:address", super.getPage("plant.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("plant.list.page"));
		mav.addAllObjects(this.plantService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord())) ;
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(int plid) {
		ModelAndView mav = new ModelAndView(super.getPage("plant.edit.page"));
		mav.addAllObjects(this.plantService.editPre(plid)) ;
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("check_name_myself")
	@ResponseBody
	public Object checkNameMyself(int plid,String name) {
		Plant plant = (Plant)this.plantService.get(plid).get("plant") ;
		if(name.equals(plant.getName())){
			return true ;
		}
		return this.plantService.get(name) == null ;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("edit")
	public ModelAndView edit(Plant plant,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Plant oldPlant = (Plant)this.plantService.get(plant.getPlid()).get("plant") ;
		if(oldPlant == null || oldPlant.getFlag() == 0) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url",super.getPage("plant.list.action")) ;
		}else {
			plant.setIndate(new Date());
			plant.setFlag(1);
			plant.setRecorder(super.loginMid());
			if(pic.getSize() != 0) {
				String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
				String photo = "upload/plant/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
				plant.setPhoto(photo);
				if(this.plantService.edit(plant)) {
					try {
						pic.transferTo(new File(file + photo));
						super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.success", TITLE);
					} catch (Exception e) {
						super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.failure", TITLE);
					}
				}else {
					super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.failure", TITLE);
				}
			}else {
				if(this.plantService.edit(plant)) {
					super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "plant.list.action", "vo.edit.failure", TITLE);
				}
			}
		}
		return mav;
	}
	@RequiresRoles("plant")
	@RequiresPermissions("plant:edit")
	@RequestMapping("remove")
	public ModelAndView remove(int plid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Plant plant = (Plant)this.plantService.get(plid).get("plant") ;
		if(plant == null || plant.getFlag() == 0) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url",super.getPage("plant.list.action")) ;
		}else {
			if(this.plantService.remove(plid)) {
				super.setMsgAndUrl(mav, "plant.list.action", "vo.delete.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "plant.list.action", "vo.delete.failure", TITLE);
			}
		}
		return mav;
	}
	@RequestMapping("show_info") 
	@ResponseBody
	public Object showInfo(int plid) {
		return this.plantService.get(plid) ;
	}
}
