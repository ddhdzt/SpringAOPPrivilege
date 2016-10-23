package cn.edu.scut.springaop.xml.privilege.service;

import cn.edu.scut.springaop.xml.privilege.annotation.PrivilegeInfo;
import cn.edu.scut.springaop.xml.privilege.dao.PersonDao;

public class PersonServiceImpl implements PersonService{

	private PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@PrivilegeInfo(name="savePerson")
	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
	}

	@PrivilegeInfo(name="updatePerson")
	public void updatePerson() {
		// TODO Auto-generated method stub
		this.personDao.updatePerson();
	}

}
