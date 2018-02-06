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
import cn.weicao.mxr.service.ICustomerService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.Customer;

@Controller
@RequestMapping("/pages/back/admin/customer/*")
public class CustomerAction extends AbstractAction {
	private static final String TITLE = "公司" ;
	@Resource
	private ICustomerService customerService ;
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("customer.add.page"));
		mav.addAllObjects(this.customerService.addPre()) ;
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("get_city")
	@ResponseBody
	public Object getCity(int pid) {
		return this.customerService.getCity(pid) ;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("check_name")
	@ResponseBody
	public Object checkName(String name) {
		return this.customerService.get(name) == null ;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("add")
	public ModelAndView add(Customer customer,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if((boolean)this.checkName(customer.getName()) == false) {
			mav.addObject("msg", "该公司名称已存在！") ;
			mav.addObject("url",super.getPage("customer.add.action")) ;
		}else {
			customer.setFlag(1);
			customer.setIndate(new Date());
			customer.setRecorder(super.loginMid());
			String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
			String photo = "upload/customer/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			customer.setPhoto(photo);
			if(this.customerService.add(customer)) {
				try {
					pic.transferTo(new File(file + photo));
					super.setMsgAndUrl(mav, "customer.list.action", "vo.add.success", TITLE);
				} catch (Exception e) {
					super.setMsgAndUrl(mav, "customer.list.action", "vo.add.failure", TITLE);
				}
			}else {
				super.setMsgAndUrl(mav, "customer.list.action", "vo.add.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:list")
	@RequestMapping("list")
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("公司编号:ctid|公司名称:name|公司地址:address", super.getPage("customer.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("customer.list.page"));
		mav.addAllObjects(this.customerService.list(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyWord())) ;
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(int ctid) {
		ModelAndView mav = new ModelAndView(super.getPage("customer.edit.page"));
		mav.addAllObjects(this.customerService.editPre(ctid)) ;
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:add")
	@RequestMapping("check_name_myself")
	@ResponseBody
	public Object checkNameMyself(int ctid,String name) {
		Customer customer = this.customerService.get(ctid) ;
		if(name.equals(customer.getName())){
			return true ;
		}
		return this.customerService.get(name) == null ;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:edit")
	@RequestMapping("edit")
	public ModelAndView edit(Customer customer,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Customer oldCustomer = this.customerService.get(customer.getCtid()) ;
		if(oldCustomer == null || oldCustomer.getFlag() == 0) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url",super.getPage("customer.list.action")) ;
		}else {
			customer.setIndate(new Date());
			customer.setFlag(1);
			customer.setRecorder(super.loginMid());
			if(pic.getSize() != 0) {
				String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
				String photo = "upload/customer/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
				customer.setPhoto(photo);
				if(this.customerService.edit(customer)) {
					try {
						pic.transferTo(new File(file + photo));
						super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.success", TITLE);
					} catch (Exception e) {
						super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.failure", TITLE);
					}
				}else {
					super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.failure", TITLE);
				}
			}else {
				if(this.customerService.edit(customer)) {
					super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "customer.list.action", "vo.edit.failure", TITLE);
				}
			}
		}
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:edit")
	@RequestMapping("remove")
	public ModelAndView remove(int ctid) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Customer customer = this.customerService.get(ctid) ;
		if(customer == null || customer.getFlag() == 0) {
			mav.addObject("msg", "非法操作！") ;
			mav.addObject("url",super.getPage("customer.list.action")) ;
		}else {
			if(this.customerService.remove(ctid)) {
				super.setMsgAndUrl(mav, "customer.list.action", "vo.delete.success", TITLE);
			}else {
				super.setMsgAndUrl(mav, "customer.list.action", "vo.delete.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("customer")
	@RequiresPermissions("customer:list")
	@RequestMapping("list_details")
	public ModelAndView listDetails(int ctid) {
		ModelAndView mav = new ModelAndView(super.getPage("customer.list.details.page"));
		mav.addAllObjects(this.customerService.listDetails(ctid)) ;
		return mav;
	}
}
