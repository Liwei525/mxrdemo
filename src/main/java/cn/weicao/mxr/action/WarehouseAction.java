package cn.weicao.mxr.action;

import java.io.File;
import java.util.Date;
import java.util.Map;
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
import cn.weicao.mxr.service.IWarehouseService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.Warehouse;

@Controller
@RequestMapping("/pages/back/admin/warehouse/*")
public class WarehouseAction extends AbstractAction {
	private static final String TITLE = "仓库" ;
	@Resource
	private IWarehouseService warehouseService ;
	
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.add.page"));
		mav.addAllObjects(this.warehouseService.addPre()) ;
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("get_city")
	@ResponseBody
	public Object getCity(int pid) {
		return this.warehouseService.getCity(pid) ;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("check_name")
	@ResponseBody
	public Object checkName(String name) {
		return this.warehouseService.get(name) == null ;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("add")
	public ModelAndView add(Warehouse warehouse,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if((boolean)this.checkName(warehouse.getName()) == false) {
			mav.addObject("msg", "该仓库名称已存在！") ;
			mav.addObject("url",super.getPage("warehouse.add.pre.action")) ;
		}else {
			warehouse.setRecorder(super.loginMid());
			warehouse.setRecordDate(new Date());
			warehouse.setFlag(1);
			String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
			String photo = "upload/warehouse/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			warehouse.setPhoto(photo);
			if(this.warehouseService.add(warehouse)) {
				try {
					pic.transferTo(new File(file + photo));
					super.setMsgAndUrl(mav, "warehouse.list.action", "vo.add.success", TITLE);
				} catch (Exception e) {
					super.setMsgAndUrl(mav, "warehouse.add.pre.action", "vo.add.failure", TITLE);
				}
			}else {
				super.setMsgAndUrl(mav, "warehouse.add.pre.action", "vo.add.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("仓库名称:name|仓库地址:address", super.getPage("warehouse.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.list.page"));
		mav.addAllObjects(this.warehouseService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord())) ;
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:list")
	@RequestMapping("get_ucgoods")
	@ResponseBody
	public Object getUCGoods(int wid,int jsCommonCp,int jsCommonLs) {
		return this.warehouseService.getAllUCGoodsByWid(wid,jsCommonCp,jsCommonLs) ;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(int wid) {
		ModelAndView mav = new ModelAndView(super.getPage("warehouse.edit.page"));
		mav.addAllObjects(this.warehouseService.editPre(wid)) ;
		return mav;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:add")
	@RequestMapping("check_name_myself")
	@ResponseBody
	public Object checkNameMyself(int wid,String name) {
		Map<String,Object> map = this.warehouseService.get(wid) ;
		Warehouse warehouse = (Warehouse)map.get("warehouse") ;
		if(warehouse.getName().equals(name)) {
			return true ;
		}
		return this.warehouseService.get(name) == null ;
	}
	@RequiresRoles("warehouse")
	@RequiresPermissions("warehouse:edit")
	@RequestMapping("edit")
	public ModelAndView edit(Warehouse warehouse, MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Warehouse oldWarehouse = (Warehouse)this.warehouseService.get(warehouse.getWid()).get("warehouse") ;
		if(oldWarehouse.getFlag() == 0 || (boolean)this.checkNameMyself(warehouse.getWid(), warehouse.getName()) == false) {
			super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.failure", TITLE);
		}else {
			warehouse.setFlag(1);
			warehouse.setRecordDate(new Date());
			warehouse.setRecorder(super.loginMid());
			if(pic.getSize() != 0) {
				String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
				String photo = "upload/warehouse/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
				warehouse.setPhoto(photo);
				if(this.warehouseService.edit(warehouse)) {
					try {
						pic.transferTo(new File(file + photo));
						super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.success", TITLE);
					} catch (Exception e) {
						super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.failure", TITLE);
					}
				}else {
					super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.failure", TITLE);
				}
			}else {
				if(this.warehouseService.edit(warehouse)) {
					super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "warehouse.list.action", "vo.edit.failure", TITLE);
				}
			}
		}
		return mav;
	}
	@RequestMapping("show_info")
	@ResponseBody
	public Object showInfo(int wid) {
		return this.warehouseService.get(wid) ; 
	}
}
