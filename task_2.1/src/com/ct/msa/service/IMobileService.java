package com.ct.msa.service;

import java.util.Map;

import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;

public interface IMobileService {

	public void addMobile(Mobile m) throws MobileException;

	public Map<Integer, Mobile> display();

	public void deleteMobile(int mId) throws MobileException;

	public void updateMobileDetails(Mobile m);

	public Mobile searchMobileById(int mId) throws MobileException;

}
