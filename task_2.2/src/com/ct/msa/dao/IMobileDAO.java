package com.ct.msa.dao;

import java.util.Collection;
import java.util.Map;

import com.ct.msa.model.Mobile;

public interface IMobileDAO {


	public Mobile addMobile(Mobile m) throws MobileException;
	
	public Collection display() throws MobileException;


	public void deleteMobile(int mId) throws MobileException;



	public Mobile searchMobileById(int mId) throws MobileException;

}