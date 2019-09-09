package com.ct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ct.dao.ProductDao;
import com.ct.model.Product;
import com.ct.model.User;

@Component
public interface IServiceLayer {

public int saveProduct(Product p);
public int saveRegister(User user);
public Product searchById(int id);
public int delete(int id);
public List display();
public String login(User obj);
}
