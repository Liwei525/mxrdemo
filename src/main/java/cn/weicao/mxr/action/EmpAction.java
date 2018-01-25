package cn.weicao.mxr.action;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IDeptService;
import cn.weicao.mxr.service.IEmpService;
import cn.weicao.mxr.util.web.SplitPageUtil;
import cn.weicao.mxr.vo.Dept;
import cn.weicao.mxr.vo.Emp;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpAction extends AbstractAction{
	private static final String TITLE = "雇员" ;
	@Resource
	private IEmpService empService ;
	@Resource
	private IDeptService deptService ;
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("check_eid")
	@ResponseBody
	public Object checkEid(String eid) {
		if(this.empService.get(eid) == null) {
			return true ;
		}else {
			return false ;
		}
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("check_did")
	@ResponseBody
	public Object checkDid(int did) {
		Dept dept = this.deptService.get(did) ;
		if(dept.getCurrnum() < dept.getMaxnum()) {
			return true ;
		}else {
			return false ;
		}
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("emp.add.page"));
		mav.addAllObjects(this.empService.addPre()) ;
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	@RequestMapping("add")
	public ModelAndView add(Emp emp , MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(!(boolean)this.checkEid(emp.getEid()) == true) {
			mav.addObject("msg", "该雇员编号已存在！") ;
			mav.addObject("url",super.getPage("emp.add.pre.action")) ;
		}else {
			String loginEid = (String)SecurityUtils.getSubject().getPrincipal() ;
			emp.setState(1);
			emp.setHiredate(new Date());
			emp.setPassword("EAB62A7769F0313F8D69CEBA32F4347E");
			emp.setIneid(loginEid);
			String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
			String photo = "upload/emp/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			emp.setPhoto(photo);
			if(this.empService.add(emp)) {
				try {
					pic.transferTo(new File(file + photo));
					super.setMsgAndUrl(mav, "emp.list.action", "vo.add.success", TITLE);
				} catch (Exception e) {
					super.setMsgAndUrl(mav, "emp.add.pre.action", "vo.add.failure", TITLE);
				}
			}else {
				super.setMsgAndUrl(mav, "emp.add.pre.action", "vo.add.failure", TITLE);
			}
		}
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("雇员姓名:ename|联系电话:phone|是否离职(0：离职，1：在职):state", super.getPage("emp.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("emp.list.page"));
		mav.addAllObjects(this.empService.list(spu.getCurrentPage(), spu.getLineSize(),spu.getColumn(), spu.getKeyWord(), spu.getStartTime(), spu.getEndTime())) ;
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	@RequestMapping("edit_pre")
	public ModelAndView editPre(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("emp.edit.page"));
		Emp emp = (Emp)this.empService.editPre(eid).get("emp") ;
		if(emp == null) {
			mav.addObject("errors", "不存在该雇员！") ;
		}
		mav.addAllObjects(this.empService.editPre(eid)) ;
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	@RequestMapping("edit")
	public ModelAndView edit(Emp emp,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Emp oldEmp = this.empService.get(emp.getEid()) ;
		if(oldEmp.getLid() == 0 || oldEmp.getState() == 0) {
			super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.failure", TITLE);
		}else {
			String loginEid = (String)SecurityUtils.getSubject().getPrincipal() ;
			emp.setState(oldEmp.getState());
			emp.setHiredate(oldEmp.getHiredate());
			emp.setPassword(oldEmp.getPassword());
			emp.setIneid(oldEmp.getIneid());
			emp.setOuteid(loginEid);
			if(pic.getSize() != 0) {
				String file = super.getRequest().getServletContext().getRealPath("/") + "WEB-INF/";
				String photo = "upload/emp/" + UUID.randomUUID().toString() + pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
				emp.setPhoto(photo);
				if(this.empService.edit(emp)) {
					try {
						pic.transferTo(new File(file + photo));
						super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.success", TITLE);
					} catch (Exception e) {
						super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.failure", TITLE);
					}
				}else {
					super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.failure", TITLE);
				}
			}else {
				if(this.empService.edit(emp)) {
					super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "emp.list.action", "vo.edit.failure", TITLE);
				}
			}
		}
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:state")
	@RequestMapping("state_pre")
	public ModelAndView statePre(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("emp.state.page"));
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:state")
	@RequestMapping("state")
	public ModelAndView statePre(String eid,String leaveDate,String leaveNote) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		String loginEid = (String)SecurityUtils.getSubject().getPrincipal() ;
		if(this.empService.state(eid, leaveDate, leaveNote, loginEid)) {
			super.setMsgAndUrl(mav, "emp.list.action", "vo.state.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "emp.list.action", "vo.state.failure", TITLE);
		}
		return mav;
	}
	@RequiresRoles("emp")
	@RequiresPermissions("emp:list")
	@RequestMapping("list_details") 
	public ModelAndView listDetails(String eid) {
		ModelAndView mav = new ModelAndView(super.getPage("emp.list.details.page"));
		mav.addAllObjects(this.empService.getMyself(eid)) ;
		return mav;
	}
	@RequestMapping("show_emp")
	@ResponseBody
	public Object showEmp(String eid) {
		Map<String,Object> map = this.empService.getMyself(eid) ;
		String loginEid = (String)SecurityUtils.getSubject().getPrincipal() ;
		int did = this.empService.get(loginEid).getDid() ;
		if(did == 1 || did == 2) {
			map.put("flag", true) ;
		}else {
			map.put("flag", false) ;
		}
		return map ;
	}
}
