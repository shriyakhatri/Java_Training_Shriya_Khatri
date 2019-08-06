package com.ct.msa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ct.msa.dao.IMobileDAO;
import com.ct.msa.dao.MobileDaoImpl;
import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;
import com.ct.msa.ui.Client;

public class MobileServiceImp1 implements IMobileService {
	IMobileDAO daoObj = new MobileDaoImpl();

	@Override
	public void addMobile(Mobile m) throws MobileException {

		ArrayList<String> arrli = new ArrayList<String>();
		arrli.add("nokia");
		arrli.add("lumia");
		arrli.add("redmi");
		arrli.add("apple");
		arrli.add("oppo");
		arrli.add("viva");
		boolean checkname = false;
		boolean checkid = false;
		String sname = m.getName();
		String sid = Integer.toString(m.getId());
		int id = m.getId();
		if (arrli.contains(sname))
			checkname = true;
		if (sid.length() <= 4) {
			checkid = true;
		}
		if (checkname == true && checkid == true) {
			Client.check_add = true;
			//IMobileDAO d = new MobileDaoImpl();
			daoObj.addMobile(m);
		
		} else {
			Client.check_add= false;
		}
		
	}

	@Override
	public void deleteMobile(int mId) throws MobileException {
		// TODO Auto-generated method stub
		String mid1 = Integer.toString(mId);
		if (mid1.length() <= 4) {
			//IMobileDAO d = new MobileDaoImpl();
			daoObj.deleteMobile(mId);
		}
	}

	

	@Override
	public Mobile searchMobileById(int mid) throws MobileException, SQLException {

		String mId = Integer.toString(mid);
		//IMobileDAO d = new MobileDaoImpl();
		Mobile m= new Mobile();
		if (mId.length() <= 4) {
			m = daoObj.searchMobileById(mid);
		}
		return m;
		// TODO Auto-generated method stub

	}

	public  Collection display() throws MobileException {
		return daoObj.display();

	}

	@Override
	public boolean check_user(String username, String password, int choice) {
		boolean result = false;
		//IMobileDAO d1 = new MobileDaoImpl();
       result = daoObj.check_user(username, password, choice);
		// TODO Auto-generated method stub
		return result;
	}

}
