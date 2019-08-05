package com.ct.msa.dao;

import java.util.Map;

import com.ct.msa.model.Mobile;

public interface IMobileDAO {
	public Map<Integer, Mobile> display();

	public Mobile addMobile(Mobile m) throws MobileException;

	public void deleteMobile(int mId) throws MobileException;

	public void updateMobileDetails(int mId);

	public Mobile searchMobileById(int mId) throws MobileException;

}