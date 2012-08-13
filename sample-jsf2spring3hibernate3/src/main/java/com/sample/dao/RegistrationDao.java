package com.sample.dao;

import java.util.List;

import com.sample.entity.Registration;
import com.sample.mb.ui.RegistrationForm;

public interface RegistrationDao {

	public boolean saveRecord(RegistrationForm form);
	public List<Registration> getList(int firstRec, int maxRec);
}
