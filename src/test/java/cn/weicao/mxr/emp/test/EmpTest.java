package cn.weicao.mxr.emp.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.weicao.mxr.service.IEmpService;

@ContextConfiguration(locations = {"classpath:spring/spring-base.xml","classpath:spring/spring-datasource.xml","classpath:spring/spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmpTest {
	@Resource
	private IEmpService empService ;
	@Test
	public void testGet() {
		System.err.println(this.empService.get("mxr-sale"));
	}
	@Test
	public void testRoleAndAction() {
		System.err.println(this.empService.getRolesAndAction("mxr-human"));
	}
}
