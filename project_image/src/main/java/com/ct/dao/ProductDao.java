  package com.ct.dao;
import java.util.List;

import org.hibernate.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.ct.model.Product;
import com.ct.model.User;

@Component
public class ProductDao implements IProductDao {
	
	public int saveProduct(Product p) {
		System.out.println("here");
		Configuration cf = new Configuration();
    	cf.configure("hibernate.cfg.xml");
    	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
    	Session session = sf.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
		return 1;
	
	}

public Product searchById(int id)
{
	Configuration cf = new Configuration();
	cf.configure("hibernate.cfg.xml");
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
    session.beginTransaction();  
    
     Product p=  (Product) session.get(Product.class, id);
    
     session.save(p);
     session.getTransaction().commit();
     session.close();
	return p;

}

public List display() {
	
	Configuration cf = new Configuration();
	cf.configure("hibernate.cfg.xml");
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
    session.beginTransaction();  
     
    String qry = "select p from Product p";
    Query qr = session.createQuery(qry);
    List<Product> l = qr.list();
   /*
    session.save(p);
    session.getTransaction().commit();
    session.close();*/
    
	return l ;
}


public int delete(int id)
{
	Configuration cf = new Configuration();
	cf.configure("hibernate.cfg.xml");
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
    session.beginTransaction();  
    
    Product p =  (Product) session.get(Product.class, id);
    // System.out.println(t1.getName());
    session.delete(p);
	
    
    
    session.getTransaction().commit();
    session.close();
	
	return 1;
}

public String login(User obj)
{
	Configuration cf = new Configuration();
	cf.configure("hibernate.cfg.xml");
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
    session.beginTransaction();  
   
   String username= obj.getUsername();
   String password= obj.getPassword();
   User user =  (User) session.get(User.class, username);
  
   if(username.equals("admin") && password.equals("admin"))
   {
	   System.out.println("here");
	   return "main";
   }
	  
   else if(user.getUsername().equals(null) || user.getPassword().equals(null))
   {
	   return "index";
   }
   
   
   
   else if(user.getUsername().equals(username))
   {
	    if (user.getPassword().equals(password))
	    {
	    	return "display";
	    }

	  
   }
	   
    
    return "index";
	
		
}


public int saveRegister(User user) {
	System.out.println("here");
	Configuration cf = new Configuration();
	cf.configure("hibernate.cfg.xml");
	SessionFactory sf =  new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    session.close();
	return 1;

}

}



