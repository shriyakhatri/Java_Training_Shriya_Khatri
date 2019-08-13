package com.ct.msa.ui;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.ct.msa.dao.MobileException;
import com.ct.msa.model.Mobile;
import com.ct.msa.service.IMobileService;
import com.ct.msa.service.MobileServiceImp1;

public class Client
{
	static Logger log = Logger.getLogger(Client.class);

	public static boolean check_add = false;
    Mobile mobileObj= new Mobile();
    static IMobileService serviceObj = new MobileServiceImp1();
    
    Scanner sc = new Scanner(System.in);
    
	void options_customers() throws MobileException, SQLException
	{
		
		System.out.println(" inorder to perform search please enter id ");
		System.out.print("enter the mobile id ");
        int mid = sc.nextInt();
		log.info("user has enter id "+mid);

		mobileObj = serviceObj.searchMobileById(mid);
		log.info("ID is sent to service to search");

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
			log.info("user has selected option ="+n);
		switch(n)
		{
			case 1:
				try
				{
				System.out.println("To add please enter the following things ");
				System.out.println("Enter id");
				int id = sc.nextInt();
				log.info("user has entered id = "+id);
				System.out.println("Enter name");

				sc.nextLine();
				String name = sc.nextLine();
				log.info("user has entered name = "+name);

				System.out.println("Enter description");
                String description = sc.nextLine();
				log.info("user has entered description = "+description);

				System.out.println("Enter price");
                int price = sc.nextInt();
				log.info("user has entered price = "+price);

				
                mobileObj.setPrice(price);
				mobileObj.setDescription(description);
				mobileObj.setName(name);
				mobileObj.setId(id);
                serviceObj.addMobile(mobileObj);
                log.debug("add method of service is being called");
				}
                catch(InputMismatchException e)
				{
                	log.error("user has entered invalid inputs");
                	throw new MobileException("invalid inputs");
                	
				}

				
                if(Client.check_add== true)
					{
                	System.out.println("details added successfully");
                   log.info("user details are added successfully");
                   }
				else
					System.out.println("Please enter valid details");
                    log.info("details are not added due to invalid inputs");
				
				break;
			case 2:
				System.out.print("enter the mobile id ");
				int mid = sc.nextInt();
				log.info("user has entered id="+mid);
				mobileObj = serviceObj.searchMobileById(mid);
				log.debug("search by id is method of service is called");

				System.out.println("id =" + mobileObj.getId() + " price is " + mobileObj.getPrice() + "name is " + mobileObj.getName());
				break;

			case 3:
				System.out.print("enter the mobile id ");
				serviceObj = new MobileServiceImp1();
				int mid1 = sc.nextInt();
				log.info("user has entered id = "+mid1);
				serviceObj.deleteMobile(mid1);
				log.debug("delete mobile method of service is called");
                break;
		
			
			case 4:
				System.out.println("displaying mobiles ");
			    Map<Integer, Mobile > map1 = new HashMap<>();
				System.out.println(serviceObj.display());
				log.debug("display mobile method of service is called");

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
		log.info("scanner obj is created");
		System.out.println("1. admin");
		System.out.println("2. customer");
		
		int n = sc.nextInt();
		log.info("user has selected who is he");

		
		switch (n)
		{
		case 1:
			
			boolean a_result=false;
			String a_username;
			String a_password;
			
			System.out.println("enter the username");
			a_username = sc.next();
			log.info("admin has entered his username as "+a_username);
			System.out.println("enter the password");
			a_password = sc.next();
			log.info("admin has entered his password as "+a_username);

			a_result = serviceObj.check_user(a_username, a_password, 1);
			log.info("check_user method of service layer is called ");
			if(a_result ==true)
			{
				System.out.println("you have logged in successfully");
				log.info("admin has logged in successfully");

				try{
					c.options_admin();
					log.info("various options is given to user according to their privilage");

				}
				catch(MobileException m) {
					System.out.println(m.getMessage());
				}
				
			}
			else
			{
				System.out.println("username or password is incorrect");
				log.error("username or password is incorrect");
			}
			
		    break;
		
		case 2:
			boolean c_result=false;
			String c_username;
			String c_password;
			
			System.out.println("enter the username");
			c_username = sc.next();
			log.info("admin has entered his username as "+c_username);

			System.out.println("enter the password");
			c_password = sc.next();
			log.info("admin has entered his password as "+c_username);

			c_result = serviceObj.check_user(c_username, c_password, 2);
			log.info("check_user method of service layer is called ");

			if(c_result == true)
			{
				System.out.println("you have logged in successfully");
				try
				{
				c.options_customers();
				log.info("various options is given to user according to their privilage");

				}
				catch(MobileException m)
				{
					System.out.println(m.getMessage());
				}
			}
			else
			{
				System.out.println("username or password is incorrect");
				log.error("username or password is incorrect");

			}
			break;
			
		default:
			System.out.println("please choose from given numbers only");
            break;
		}
		
	
	}while(true);
	
	
		
	
	}
	
}

