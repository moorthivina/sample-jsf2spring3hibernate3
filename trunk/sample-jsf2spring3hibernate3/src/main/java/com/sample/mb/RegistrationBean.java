package com.sample.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.sample.dao.RegistrationDao;
import com.sample.entity.Registration;
import com.sample.mb.ui.RegistrationForm;

@ManagedBean
@RequestScoped
public class RegistrationBean {
	private RegistrationForm registrationForm = null;
	private List<String> interests = null;
	private List<String> genders = null;

	@ManagedProperty(value = "#{registrationDaoImpl}")
	private RegistrationDao dao;
	
	private List<Registration> regUsers = null;
	
	private final int maxRec = 10;

	public RegistrationBean() {
		this.interests = new ArrayList<String>();
		this.interests.add("Sports");
		this.interests.add("Gadgets");
		this.interests.add("Politics");
		this.interests.add("Technology");

		this.genders = new ArrayList<String>();
		this.genders.add("Male");
		this.genders.add("Female");

	}

	public String register() {
		System.out.println("register....." + dao);
		// store data in DB
		System.out.println(this.registrationForm);
		dao.saveRecord(this.registrationForm);
		this.regUsers = getUsersList(1);
		for(Registration r:regUsers) 
			System.out.println(r.getFirstName());
		return "index";// go to welcome.xhtml
	}

	private List<Registration> getUsersList(int firstRec){
		return dao.getList(firstRec, maxRec);
	}
	
	public RegistrationForm getRegistrationForm() {
		if (this.registrationForm == null) {
			this.registrationForm = new RegistrationForm();
		}
		return registrationForm;
	}

	public void setRegistrationForm(RegistrationForm registrationForm) {
		this.registrationForm = registrationForm;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getGenders() {
		return genders;
	}

	public void setGenders(List<String> genders) {
		this.genders = genders;
	}

	public RegistrationDao getDao() {
		return dao;
	}

	public void setDao(RegistrationDao dao) {
		this.dao = dao;
	}

	public List<Registration> getRegUsers() {
		return regUsers;
	}

	public void setRegUsers(List<Registration> regUsers) {
		this.regUsers = regUsers;
	}

	public int getMaxRec() {
		return maxRec;
	}
	
}
