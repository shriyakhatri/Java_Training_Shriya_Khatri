package com.ct.msa.ui;
import java.util.*;
import java.util.Map.Entry;

import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;
import com.ct.msa.service.IMobileService;
import com.ct.msa.service.MobileServiceImp1;
public class Client
{
    public static boolean check_add = false;
    Mobile mobileObj= null;
    IMobileService serviceObj = null;
    
    Scanner sc = new Scanner(System.in);
//	IMobileService i = new  MobileServiceImp1();
	void options_customers() throws MobileException
	{
		Mobile mo1 = new Mobile();
		System.out.println(" inorder to perform search please enter id ");
		
		System.out.print("enter the mobile id ");
		IMobileService s = null;
		s = new MobileServiceImp1();
		int mid = sc.nextInt();
		
		mo1 = s.searchMobileById(mid);
		System.out.println("id =" + mo1.getId() + " price is " + mo1.getPrice() + "name is " + mo1.getName());		
		
	}
	
	void options_admin() throws MobileException
	{
int n;
		
		
		
		
		
		do{
			
			System.out.println("enter the number from below");
			System.out.println("1.add mobile ");
			System.out.println("2.search mobile by id");
			System.out.println("3.delete mobile");
		
			System.out.println("4.display all mobiles");

			System.out.println("exit");
			n = sc.nextInt();
		
		switch(n)
		{
			case 1:
				System.out.print("please enter id, name, description, price ");
				int id = sc.nextInt();
				String name = sc.next();
				String description = sc.next();
				
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
				
				break;

			case 2:
				System.out.print("enter the mobile id ");
				IMobileService s = null;
				s = new MobileServiceImp1();
				int mid = sc.nextInt();
				Mobile mo = new Mobile();
				mo = s.searchMobileById(mid);
				System.out.println("id =" + mo.getId() + " price is " + mo.getPrice() + "name is " + mo.getName());
				break;

			case 3:
				System.out.print("enter the mobile id ");
				IMobileService s1 = null;
				s1 = new MobileServiceImp1();
				int mid1 = sc.nextInt();
				s1.deleteMobile(mid1);

				break;
		
			
			case 4:
				System.out.println("displaying mobiles ");
				
				IMobileService i2 = null;
				i2 = new MobileServiceImp1();
				Mobile m3 = new Mobile();
			    Map<Integer, Mobile > map1 = new HashMap<>();
				//map1 = i2.display();
				System.out.println(i2.display());
		        Iterator<Entry<Integer, Mobile>> hmIterator = map1.entrySet().iterator(); 
		        while (hmIterator.hasNext()) { 
		        	Entry entry = hmIterator.next();   
		        	Mobile m5 = (Mobile) entry.getValue();
		        	System.out.println("id =" + m5.getId() + " price is " + m5.getPrice() + "name is " + m5.getName() + "Description is " + m5.getDescription());
		        }
				break;
		
		
		 default:
			 System.out.print("Please enter valid number ");
			 break;
		 }}while(true);	
		 }

	
	
	public static void main(String[] args) throws MobileException {
		// TODO Auto-generated method stub
	
		Client c = new Client();
		
		do
	{
		System.out.println("Please select who you are to login");
		Scanner sc = new Scanner(System.in);
		System.out.println("1. admin");
		System.out.println("2. customer");
		int n = sc.nextInt();
		switch (n)
		{
		case 1:
			
			boolean a_result=false;
			String a_username;
			String a_password;
			System.out.println("enter the username");
			a_username = sc.next();
			System.out.println("enter the password");
			a_password = sc.next();
			IMobileService i2 = null;
			i2 = new MobileServiceImp1();
			a_result = i2.check_user(a_username, a_password, 1);
			if(a_result ==true)
			{
				System.out.println("you have logged in successfully");
				c.options_admin();
			}
			else
			{
				System.out.println("username or password is incorrect");
			}
		    break;
		
		case 2:
			boolean c_result=false;
			String c_username;
			String c_password;
			System.out.println("enter the username");
			c_username = sc.next();
			System.out.println("enter the password");
			c_password = sc.next();
			IMobileService i3 = null;
			i3 = new MobileServiceImp1();
			c_result = i3.check_user(c_username, c_password, 2);
			if(c_result == true)
			{
				System.out.println("you have logged in successfully");
				c.options_customers();
			}
			else
			{
				System.out.println("username or password is incorrect");
			}
		}
		break;
		


	
	}while(true);
	
	
	}
	
}

