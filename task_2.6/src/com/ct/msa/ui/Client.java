package com.ct.msa.ui;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;
import com.ct.msa.service.IMobileService;
import com.ct.msa.service.MobileServiceImp1;
public class Client
{
    public static boolean check_add = false;
    Mobile mobileObj= new Mobile();
    static IMobileService serviceObj = new MobileServiceImp1();
    
    Scanner sc = new Scanner(System.in);
	void options_customers() throws MobileException, SQLException
	{
		
		System.out.println(" inorder to perform search please enter id ");
		System.out.print("enter the mobile id ");
        int mid = sc.nextInt();
		mobileObj = serviceObj.searchMobileById(mid);
		System.out.println("id =" + mobileObj.getId() + " price is " + mobileObj.getPrice() + "name is " + mobileObj.getName());		
		
	}
	
	void options_admin() throws MobileException, SQLException
	{
       int n=5;
		do{
			//sc.nextLine();
			System.out.println("enter the number from below");
			System.out.println("1.add mobile ");
			System.out.println("2.search mobile by id");
			System.out.println("3.delete mobile");
		    System.out.println("4.display all mobiles");
            System.out.println("5.exit");
			n = sc.nextInt();
		switch(n)
		{
			case 1:
				try
				{
				System.out.println("To add please enter the following things ");
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter description");
                String description = sc.nextLine();
				System.out.println("Enter price");
                int price = sc.nextInt();
				
				
                mobileObj.setPrice(price);
				mobileObj.setDescription(description);
				mobileObj.setName(name);
				mobileObj.setId(id);
                serviceObj.addMobile(mobileObj);
				}
                catch(InputMismatchException e)
				{
                	throw new MobileException("invalid inputs");
                	
				}

				
                if(Client.check_add== true)
					System.out.println("details added successfully");
				else
					System.out.println("Please enter valid details");
				
				break;
			case 2:
				System.out.print("enter the mobile id ");
				int mid = sc.nextInt();
				mobileObj = serviceObj.searchMobileById(mid);
				System.out.println("id =" + mobileObj.getId() + " price is " + mobileObj.getPrice() + "name is " + mobileObj.getName());
				break;

			case 3:
				System.out.print("enter the mobile id ");
				serviceObj = new MobileServiceImp1();
				int mid1 = sc.nextInt();
				serviceObj.deleteMobile(mid1);
                break;
		
			
			case 4:
				System.out.println("displaying mobiles ");
			    Map<Integer, Mobile > map1 = new HashMap<>();
				System.out.println(serviceObj.display());
		        break;
		
			case 5:
				System.exit(0);
				break;
		 default:
			 System.out.println("Please enter valid number ");
			 break;
		 }}while(true);	
		 }

	
	
	public static void main(String[] args) throws MobileException, SQLException {
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
			a_result = serviceObj.check_user(a_username, a_password, 1);
			if(a_result ==true)
			{
				System.out.println("you have logged in successfully");
				try{
					c.options_admin();
				}
				catch(MobileException m) {
					System.out.println(m.getMessage());
				}
				
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
			
			c_result = serviceObj.check_user(c_username, c_password, 2);
			if(c_result == true)
			{
				System.out.println("you have logged in successfully");
				try
				{
				c.options_customers();
				}
				catch(MobileException m)
				{
					System.out.println(m.getMessage());
				}
			}
			else
			{
				System.out.println("username or password is incorrect");
			}
			break;
			
		default:
			System.out.println("please choose from given numbers only");
            break;
		}
		
	
	}while(true);
	
	
		
	
	}
	
}

