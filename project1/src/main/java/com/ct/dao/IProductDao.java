package com.ct.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ct.model.Product;
import com.ct.model.User;

@Component
public interface IProductDao {

public int saveProduct(Product p);
public int saveRegister(User user);
public Product searchById(int id);
public int delete(int id);
public String login(User obj);
public List display();
 
}
