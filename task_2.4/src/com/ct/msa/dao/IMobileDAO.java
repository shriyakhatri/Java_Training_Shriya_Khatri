package com.ct.msa.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.ct.msa.model.Mobile;

public interface IMobileDAO {


	public Mobile addMobile(Mobile m) throws MobileException;
	
	public Collection display() throws MobileException;


	public void deleteMobile(int mId) throws MobileException;

    public boolean check_user(String username , String password , int choice);

	public Mobile searchMobileById(int mId) throws MobileException, SQLException;

}