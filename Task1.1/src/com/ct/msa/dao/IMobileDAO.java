package com.ct.msa.dao;

import java.util.Map;

import com.ct.msa.model.Mobile;

public interface IMobileDAO {
	public Map<Integer, Mobile> display();

	public void addMobile(Mobile m);

	public void deleteMobile(int mId);

	public void updateMobileDetails(int mId);

	public Mobile searchMobileById(int mId);

}