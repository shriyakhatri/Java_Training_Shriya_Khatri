package com.ct.msa.service;

import com.ct.msa.model.Mobile;

public interface IMobileService {

	public void addMobile(Mobile m);

	public void display();

	public void deleteMobile(int mId);

	public void updateMobileDetails(Mobile m);

	public void searchMobileById(int mId);

}
