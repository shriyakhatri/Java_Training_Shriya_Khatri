package com.ct.msa.service;

import java.util.ArrayList;

import com.ct.msa.dao.IMobileDAO;
import com.ct.msa.dao.MobileDaoImpl;
import com.ct.msa.model.Mobile;
import com.ct.msa.ui.Client;

public class MobileServiceImp1 implements IMobileService {

	@Override
	public void addMobile(Mobile m) {

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
			IMobileDAO d = new MobileDaoImpl();
			d.addMobile(m);
			// System.out.println("here");
		} else {
			Client.check_add= false;
		}
		// String arr[] = {"nokia","lumia","redmi","apple","oppo","vivo"};
		// for(String )

		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMobile(int mId) {
		// TODO Auto-generated method stub
		String mid1 = Integer.toString(mId);
		if (mid1.length() <= 4) {
			IMobileDAO d = new MobileDaoImpl();
			d.deleteMobile(mId);
		}
	}

	@Override
	public void updateMobileDetails(Mobile m) {
		// TODO Auto-generated method stub
//		String mId = Integer.toString(mid);
//		if (mId.length() <= 4) {
//			IMobileDAO d = new MobileDaoImpl();
//			d.searchMobileById(mid);
		//}

	}

	@Override
	public void searchMobileById(int mid) {

		// System.out.println("here");
		String mId = Integer.toString(mid);
		if (mId.length() <= 4) {
			IMobileDAO d = new MobileDaoImpl();
			d.searchMobileById(mid);
		}
		// TODO Auto-generated method stub

	}

	public void display() {
		IMobileDAO d1 = new MobileDaoImpl();
		d1.display();

	}

	/*public static void main(String[] args) {

		Mobile m = new Mobile();
	}*/
}
