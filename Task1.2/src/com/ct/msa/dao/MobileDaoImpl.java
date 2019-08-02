package com.ct.msa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ct.msa.model.Mobile;
import com.ct.msa.ui.Client;

public class MobileDaoImpl implements IMobileDAO {

	static ArrayList<Mobile> list = new ArrayList<Mobile>();
	public static Map<Integer, Mobile > map = new HashMap<>();
//	for(String str: listOfString){
//	   map.put(str, str.length());
//	}
//


	public void addMobile(Mobile m) {

		// ArrayList<Mobile> list=new ArrayList<Mobile>();
		//System.out.println("atdao");
        //list.add(m);
		map.put(m.getId(), m);
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }
		Client.check_add= true;
		System.out.println(map);
//		
	}

	public void deleteMobile(int mId) {
		// TODO Auto-generated method stub
		Mobile m = new Mobile();
		if(map.containsKey(mId))
		{
			m = map.remove(mId);
		}
		

	}

	public Map<Integer, Mobile> display() {
		
		Mobile m = new Mobile();
		
		Iterator hmIterator = map.entrySet().iterator(); 
	    Map<Integer, Mobile > map1 = new HashMap<>();
	    map1 = map;
		return map1;
		
		//return m;
		
//		for (Mobile mo : list) {
//
//			System.out.println("mobile id =" + mo.getId() + "<===>" + "mobile name = " + mo.getName());
// 
//			
//		}
	}

	public void updateMobileDetails(int mId) {
		

	}

	@Override
	public Mobile searchMobileById(int mId) {
		Mobile m = new Mobile();
		if(map.containsKey(mId))
		{
			m = map.get(mId);
		}
		return m;
		// .out.println("at dao");
		// TODO Auto-generated method stub
		// int x = list.indexOf(mId);
		// System.out.println(list);

		
		
		
//		for (Mobile mo : list) {
//			if (mo.getId() == mId) {
//				System.out.println("id =" + mo.getId() + " price is " + mo.getPrice() + "name is " + mo.getName());
//			}
//		}
		// System.out.println(""+get(x);
		// Iterator itr = list.iterator();

	}

}
