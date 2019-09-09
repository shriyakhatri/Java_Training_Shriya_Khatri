package com.ct.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ct.dao.IProductDao;
import com.ct.dao.ProductDao;
import com.ct.model.Product;
import com.ct.model.User;
import com.ct.service.IServiceLayer;


@Controller
public class HomeController {
   @Autowired
	IServiceLayer is;
   //ProductDao pd; 
	static List<Product> list = new ArrayList<Product> (); 
	private static final String UPLOAD_DIRECTORY ="/src/main/webapp/WEB-INF/images";  

   @RequestMapping("/")
	public  ModelAndView getHomepage() {
		ModelAndView mv=new ModelAndView();

		System.out.println("in index");
		mv.addObject("user",new User());
		mv.setViewName("index");
		return mv;
	}
	
	
	@RequestMapping("/add")
	public ModelAndView  getAddpage() {
		System.out.println("here1");
		ModelAndView mv=new ModelAndView();
		mv.addObject("product",new Product());
		mv.setViewName("add");
		return mv;
	}

	
	
	
	@RequestMapping("/addproduct")
	
	public String storeProductInDb(@Valid @ModelAttribute("product") Product product ,BindingResult br ,@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request ) throws Exception{
		if(br.hasErrors()) {
			//System.out.println(br);
			System.out.println("here2");
			return "add";
		}
		else {
			HttpSession session = request.getSession();

			saveimage(file,session);
			//String s=dh.addVehicle(vehicle);
			int msg = is.saveProduct(product);
			System.out.println("here2");
			//m.addAttribute("msg", msg);
			return "main";
				
		}
	
	}
	
	@RequestMapping("/searchbyid")
	public String  searchMobile()
	{
		
		System.out.println("search");
		return "search";
		
		
}
	
	@RequestMapping("/login")
	public ModelAndView  login( @ModelAttribute("user") User user, HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		String s = is.login(user);
		if(s.equals("display"))
		{
			System.out.println("in display");
			mv = displayMobile(request);
		}
		else if(s.equals("main"))
		{
			mv.setViewName("main");
			System.out.println("in main");
			//mv = getHomepage();
		}
		else
		{
			mv.setViewName("index");
		}
		
		//mv = displayMobile(request);
		mv.addObject("product",new Product());
		//User obj = new User();
		
		System.out.println(s);
		/*mv.setViewName(s);*/
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/search" )
	public String  searchById(@RequestParam("id") int pid, HttpServletRequest request)
	{
		
		
		System.out.println(pid);
		Product p = is.searchById(pid);
		
		/*Product p = new Product(); 
		mobile = map.get(mid);*/
		System.out.println(p);
		request.setAttribute("map",p);
		return "displayproduct";
		
		
		
	}
	
	@RequestMapping("/display")
	public ModelAndView  displayMobile(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		Product p = new Product();
		List l = is.display();
		request.setAttribute("products", l);
		System.out.println(l);
		mv.setViewName("display");

		return mv;
}

	

	@RequestMapping("/deletebyid")
	public String  deleteMobile()
	{
		
		System.out.println("delete");
		return "delete";
		
		
}
	
	
	
	@RequestMapping("/delete")
	public ModelAndView  deleteMobile(@RequestParam("id") int pid, HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		is.delete(pid);
		/*Product p = new Product();
		List l = is.display();
		request.setAttribute("products", l);
		System.out.println(l);*/
		mv.setViewName("delete");

		return mv;
}
	
	@RequestMapping("/register")
	public ModelAndView  getRegisterpage() {
		System.out.println("in register");
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",new User());
		mv.setViewName("register");
		return mv;
	}
	
	

	@RequestMapping("/registeradd")
	
	public String storeUserInfo( @Valid @ModelAttribute("user") User user,BindingResult br ){
		if(br.hasErrors()) {
			System.out.println("here2");
			return "register";
		}
		else {
			int msg = is.saveRegister(user);
			System.out.println("here2");
			//m.addAttribute("msg", msg);
			return "success";
				
		}
	
	}
	
	@RequestMapping("/back")
	public  ModelAndView  backtomain(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		mv = displayMobile(request);

		
		return mv;
	
	}

	@RequestMapping("/cart")
	public  ModelAndView  addToCart(@RequestParam("id") int id, @RequestParam("name") String name , @RequestParam("description") String description, @RequestParam("price") int price, @RequestParam("discount") int discount ,  @RequestParam("quantity") int quantity,@RequestParam("image") String image,  HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println("idddddd "+id);
		System.out.println("nameee");
	    Product p = new Product(id,name,price,quantity,description,discount,image);
	   
	    list.add(p);
	    session.setAttribute("pro", list);
		System.out.println(list);
		
		mv.setViewName("cart");

		
		return mv;
	
	}
	public void saveimage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = context.getContextPath();
	    System.out.println(path);//(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	    System.out.println("here");
	   
	   // System.out.println(path+" "+filename);        
	  
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + UPLOAD_DIRECTORY+ File.separator + filename)));  
	    stream.write(bytes); 
	    System.out.println("in save image");
	    stream.flush();  
	    stream.close();  
	           
	    
	    }  	

}
	
	



/*@RequestMapping(value = "addproduct" , method =RequestMethod.POST)
	
	public String storeProductInDb( @RequestBody @Valid @ModelAttribute("product") Product product,BindingResult br ){
		if(br.hasErrors()) {
			//System.out.println(br);
			return "add";
		}
		else {
			int msg = pd.saveProduct(product);
			//m.addAttribute("msg", msg);
			return "index";
				
		}
	*/
	
	

