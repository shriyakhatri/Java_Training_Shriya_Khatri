package com.ct.msa.ui;
import java.util.*;

import com.ct.msa.model.Mobile;
import com.ct.msa.service.IMobileService;
import com.ct.msa.service.MobileServiceImp1;
public class Client {
	
//	IMobileService i = new  MobileServiceImp1();
     public static boolean check_add = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
//		System.out.println("enter the number from below");
//		System.out.println("add mobile");
//		System.out.println("search mobile by id");
//		System.out.println("display all mobiles");
//		System.out.println("delete mobile");
//		System.out.println("exit");
		
		Scanner sc = new Scanner(System.in);
		//n = sc.nextInt();
		
		do{
			
			System.out.println("enter the number from below");
			System.out.println("1.add mobile");
			System.out.println("2.search mobile by id");
			System.out.println("5.display all mobiles");
			System.out.println("3.delete mobile");
			System.out.println("4.update mobile");
			System.out.println("exit");
			n = sc.nextInt();
		
		switch(n)
		{
			case 1:
				System.out.print("please enter name, description,id, price ");
				String name = sc.next();
				String description = sc.next();
				int id = sc.nextInt();
				int price = sc.nextInt();
				Mobile m = new Mobile();

				m.setPrice(price);
				m.setDescription(description);
				m.setName(name);
				m.setId(id);
				IMobileService i = null;
				i = new MobileServiceImp1();
				i.addMobile(m);
				if(Client.check_add== true)
					System.out.println("details added successfully");
				else
					System.out.println("Please enter valid details");
				// System.out.println(m.getId());

				break;

			case 2:
				System.out.print("enter the mobile id ");
				IMobileService s = null;
				s = new MobileServiceImp1();
				int mid = sc.nextInt();
				s.searchMobileById(mid);

				break;

			case 3:
				System.out.print("enter the mobile id ");
				IMobileService s1 = null;
				s1 = new MobileServiceImp1();
				int mid1 = sc.nextInt();
				s1.deleteMobile(mid1);

				break;
		
			case 4:
				System.out.print("enter the mobile id ");
				IMobileService s2 = null;
				s2 = new MobileServiceImp1();
				int mid2 = sc.nextInt();

				System.out.print("please enter name, description price ");
				String sname = sc.next();
				String sdescription = sc.next();
				// int sid = sc.nextInt();
				int sprice = sc.nextInt();
				Mobile m2 = new Mobile();

				m2.setPrice(sprice);
				m2.setDescription(sdescription);
				m2.setName(sname);
				m2.setId(mid2);
				IMobileService i1 = null;
				i1 = new MobileServiceImp1();
				s2.updateMobileDetails(m2);

				break;
		
			case 5:
				System.out.println("dispplaying mobiles ");
				IMobileService i2 = null;
				i2 = new MobileServiceImp1();
				i2.display();

				break;
		
		
		 default:
			 System.out.print("Please enter valid number ");
		 }}while(true);	
		 }
	}
	


