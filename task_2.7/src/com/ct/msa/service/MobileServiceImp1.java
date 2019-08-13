package com.ct.msa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ct.msa.dao.IMobileDAO;
import com.ct.msa.dao.MobileDaoImpl;
import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;
import com.ct.msa.ui.Client;

public class MobileServiceImp1 implements IMobileService {
	IMobileDAO daoObj = new MobileDaoImpl();
	static Logger log = Logger.getLogger(MobileServiceImp1.class);

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
		    log.debug("checks wether name is present in list");
			checkname = true;
		
		if (sid.length() <= 4) {
		    log.debug("checks wether id length is less than 4");

			checkid = true;
			
		}
		if (checkname == true && checkid == true) {
			Client.check_add = true;
			//IMobileDAO d = new MobileDaoImpl();
			daoObj.addMobile(m);
			log.info("add mobile method of doa is called");
		
		} else {
			Client.check_add= false;
		}
		
	}

	@Override
	public void deleteMobile(int mId) throws MobileException {
		// TODO Auto-generated method stub
		String mid1 = Integer.toString(mId);
		if (mid1.length() <= 4) {
			log.info("length of id is checked");
			//IMobileDAO d = new MobileDaoImpl();
			daoObj.deleteMobile(mId);
			log.info("delete mobile method of dao called");
		}
	}

	

	@Override
	public Mobile searchMobileById(int mid) throws MobileException, SQLException {

		String mId = Integer.toString(mid);
		//IMobileDAO d = new MobileDaoImpl();
		Mobile m= new Mobile();
		if (mId.length() <= 4) {
			log.info("length of id is checked");

			m = daoObj.searchMobileById(mid);
			log.info("search_by_id method of dao called");

			
		}
		return m;
		// TODO Auto-generated method stub

	}

	public  Collection display() throws MobileException {
		log.info("display method of dao called");

		return daoObj.display();


	}

	@Override
	public boolean check_user(String username, String password, int choice) {
		boolean result = false;
		//IMobileDAO d1 = new MobileDaoImpl();
       result = daoObj.check_user(username, password, choice);
       log.info("check_user method of dao is called");
		// TODO Auto-generated method stub
		return result;
	}

}
