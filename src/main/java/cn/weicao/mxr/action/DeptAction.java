package cn.weicao.mxr.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.weicao.mxr.action.abs.AbstractAction;
import cn.weicao.mxr.service.IDeptService;
import cn.weicao.mxr.vo.Dept;

@Controller
@RequestMapping("/pages/back/admin/dept/*")
public class DeptAction extends AbstractAction{
	private static final String ACTION_TITLE = "部门" ;
	@Resource
	private IDeptService deptService ;
	@RequiresRoles("dept")
	@RequiresPermissions("dept:add")
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.add.page"));
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:add")
	@RequestMapping("check_dname")
	@ResponseBody
	public Object checkDname(String dname) {
		Dept dept = this.deptService.getByDname(dname) ;
		if(dept == null) {
			return true;
		}else {
			return false;
		}
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:add")
	@RequestMapping("add")
	public Object add(Dept dept) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		dept.setCurrnum(0);
		if(this.deptService.add(dept)) {
			super.setMsgAndUrl(mav, "dept.list.action", "vo.add.success",ACTION_TITLE);
		}else {
			super.setMsgAndUrl(mav, "dept.add.pre.action", "vo.add.failure",ACTION_TITLE);
		}
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@RequestMapping("list") 
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getPage("dept.list.page"));
		mav.addAllObjects(this.deptService.list()) ;
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:edit")
	@RequestMapping("edit_pre") 
	public ModelAndView editPre(int did) {
		ModelAndView mav = new ModelAndView(super.getPage("dept.edit.page"));
		mav.addObject("dept", this.deptService.get(did)) ;
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:edit")
	@RequestMapping("edit") 
	public ModelAndView edit(Dept dept) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Dept oldDept = this.deptService.get(dept.getDid()) ; 
		Dept newDept = oldDept ;
		newDept.setMaxnum(dept.getMaxnum());
		if(this.deptService.edit(newDept)) {
			super.setMsgAndUrl(mav, "dept.list.action", "vo.edit.success",ACTION_TITLE);
		}else {
			super.setMsgAndUrl(mav, "dept.list.action", "vo.edit.failure",ACTION_TITLE);
		}
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@RequestMapping("list_details") 
	public ModelAndView listDetails(int did) {
		ModelAndView mav = new ModelAndView(super.getPage("dept.list.details.page"));
		mav.addAllObjects(this.deptService.listDetails(did)) ;
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions(value= {"dept:edit","dept:list"})
	@RequestMapping("edit_role") 
	public ModelAndView editRole(int did) {
		ModelAndView mav = new ModelAndView(super.getPage("dept.edit.role.page"));
		mav.addAllObjects(this.deptService.listRoleByDid(did)) ;
		return mav;
	}
	@RequiresRoles("dept")
	@RequiresPermissions(value= {"dept:edit","dept:list"})
	@RequestMapping("list_role") 
	@ResponseBody
	public Object listRole(int did) {
		return this.deptService.listRole(did) ;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@RequestMapping("save_role") 
	@ResponseBody
	public Object saveRole(int did,String rid) {
		return this.deptService.addRole(did, rid) ;
	}
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@RequestMapping("delete_role") 
	@ResponseBody
	public Object deleteRole(int did,String rid) {
		return this.deptService.deleteRole(did, rid) ;
	}
}
