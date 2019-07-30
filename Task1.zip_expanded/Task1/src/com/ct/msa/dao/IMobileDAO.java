package com.ct.msa.dao;

import com.ct.msa.model.Mobile;

public interface IMobileDAO {
	public void display();

	public void addMobile(Mobile m);

	public void deleteMobile(int mId);

	public void updateMobileDetails(int mId);

	public void searchMobileById(int mId);

}