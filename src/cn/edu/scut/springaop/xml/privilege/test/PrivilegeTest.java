package cn.edu.scut.springaop.xml.privilege.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.scut.springaop.xml.privilege.aspect.PrivilegeAspect;
import cn.edu.scut.springaop.xml.privilege.bean.Privilege;
import cn.edu.scut.springaop.xml.privilege.service.PersonService;

public class PrivilegeTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PrivilegeAspect privilegeAspect = (PrivilegeAspect)context.getBean("privilegeAspect");
		/**
		 * 给用户初始化权限值
		 */
		Privilege privilege1 = new Privilege();
		privilege1.setName("updatePerson");
		Privilege privilege2 = new Privilege();
		privilege2.setName("updatePerson");
		privilegeAspect.getPrivileges().add(privilege1);
		privilegeAspect.getPrivileges().add(privilege2);
		PersonService personService = (PersonService)context.getBean("personService");
		personService.savePerson();
		personService.updatePerson();
	}
}	
