package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ct.dao.ProductDao;
import com.ct.model.Product;
import com.ct.model.User;
@Component
public class ServiceLayer implements IServiceLayer{
	@Autowired
	ProductDao pd;
	public int saveProduct(Product p) {
 		  
		int msg = pd.saveProduct(p);
		
		return 1;
	}
	public Product searchById(int id) {
		
		Product p = pd.searchById(id);
		return p;// TODO Auto-generated method stub
		
	}
	public List display() {
		List l = pd.display();// TODO Auto-generated method stub
		return l;
	}
	public int delete(int id) {
		pd.delete(id);// TODO Auto-generated method stub
		return 1;
	}
	public String login(User obj) {
		
		String s = pd.login(obj);// TODO Auto-generated method stub
		return s;
	}
	public int saveRegister(User user) {
		
		int msg = pd.saveRegister(user);
		// TODO Auto-generated method stub
		return 1;
	}

}
