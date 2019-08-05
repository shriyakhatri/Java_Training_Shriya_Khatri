package com.ct.msa.service;

import java.util.Collection;
import java.util.Map;

import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;

public interface IMobileService {

	public void addMobile(Mobile m) throws MobileException;

	public Collection display() throws MobileException;

	public void deleteMobile(int mId) throws MobileException;

	public boolean check_user(String username, String password, int choice);
	
	public Mobile searchMobileById(int mId) throws MobileException;

}
