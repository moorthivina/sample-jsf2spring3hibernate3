package com.sample.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Registration;
import com.sample.mb.ui.RegistrationForm;

@Service("registrationDaoImpl")
public class RegistrationDaoImpl implements RegistrationDao {

	private Session session;

	@Autowired
	public void getSession(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public RegistrationDaoImpl() {
		System.out.println("dao created "+this);
	}
	
	@Override
	public boolean saveRecord(RegistrationForm form) {
		System.out.println("Registradao called ");
		Registration reg = new Registration();
		reg.setFirstName(form.getFirstName());
		reg.setLastName(form.getLastName());
		reg.setEmail(form.getEmail());
		reg.setPhone(form.getPhone());
		reg.setPassword(form.getPassword());
		session.getTransaction().begin();
		session.saveOrUpdate(reg);
		session.getTransaction().commit();
		System.out.println(reg.getId());
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getList(int firstRec, int maxRec) {
		Query query = session.createQuery("from Registration");
		/*query.setFirstResult(firstRec);
		query.setMaxResults(maxRec);*/
		return query.list();
	}
}
