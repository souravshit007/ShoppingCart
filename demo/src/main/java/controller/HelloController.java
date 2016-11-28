package controller;
import dao.ProductDAOImpl;
import dao.productServices;

import Model.*;


import java.util.*;

import javax.validation.Valid;

import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 

@EnableWebMvc
	@Controller
	public class HelloController  {
		
		@Autowired
		  public productServices productService;
		
		@Qualifier(value="productService")
	    public void setPersonService(productServices ps){
	        this.productService = ps;
	    }
		
		/*@RequestMapping("/productpage")
	    public String dispproductpage()
	    {
	    	return "productpage";
	    }(*/
		
		
		
		@RequestMapping("/")
	    public String showIndex()
	    {
	    	return "index";
	    }
		 @RequestMapping("/index")
		    public String showIndexNow()
		    {
		    	return "index";
		    }
		 
		 @RequestMapping("/signin")
		    public String showSignIn()
		    {
		    	return "signin";
		    }
		 
		 @RequestMapping("/login")
		    public String showLogin()
		    {
			 
		    	return "login";
		    }
		 
		 
		 @RequestMapping("/register")
		    public String showRegistration()
		    {
		    	return "registrationform";
		    }
		 
		 @RequestMapping("/contactus")
		    public String showContuctus()
		    {
		    	return "contactus";
		    }
		 @RequestMapping("/aboutus")
		    public String showAboutus()
		    {
		    	return "aboutus";
		    }
		 
		 @RequestMapping("/plasticfan")
		    public String showplasticfan()
		    {
		    	return "plasticfan";
		    }
		 
		@RequestMapping("/add")
	   public String addproduct1()
	    
	    {
			//ModelAndView modelAndView = new ModelAndView("addproduct");

			
	      //  modelAndView.addObject("product", new Product());

	    	return "addproduct";
	    }
		
	 @RequestMapping(value= "/productpage", method = RequestMethod.GET)
		    public String ListAllProducts(Model model)
		    {
		    	
		    	//model.addAttribute("product",new Product());
		    			model.addAttribute("listed",this.productService.listProduct());
		    	return "productpage";
		    	    }
    		    	
		      
		 @RequestMapping("/details/{id}")
		    public String getProductById(@PathVariable("id") int id,Model model)
		    		
		    {
		    	
		    	model.addAttribute("product",this.productService.getProductById(id));
		    			model.addAttribute("listed",this.productService.listProduct());
		    	return "product";
		    	    }
 	
		     
		    @RequestMapping("/delete/{id}")
		   
		    public String removeProduct(@PathVariable("id") int id,Model model)
		    {
		    	this.productService.removeProduct(id);
    			model.addAttribute("listed",this.productService.listProduct());

		    	return "redirect:/productpage";
		    }
		    
		   

		     
		   
		    @RequestMapping("/edit/{id}")
		    public String editPerson(@PathVariable("id") int id, Model model,Product p){
	    		

		       model.addAttribute("product", this.productService.getProductById(id));
		        model.addAttribute("listPersons", this.productService.listProduct());
		        return "editpage";
		    }
		    
		    
		    @RequestMapping(value= "/addproduct", method = RequestMethod.GET)
		    public String addProduct(@ModelAttribute ("product") Product p)
		    	
		    {
		    	if(p.getId()==0)
		    	{
		    		this.productService.addProduct(p);
		    		
		    	}
		    	else
		    	{
		            
		    	
		    		this.productService.updateProduct(p);
		    		
		    	}
		    	return "addproduct";
		        
		    	}
		   /* @RequestMapping(value= "/registrationform", method = RequestMethod.GET)
		    public String addCustomer(@ModelAttribute ("customer") Product p)
		    	
		    {
		    	if(p.getId()==0)
		    	{
		    		this.productService.addProduct(p);
		    		
		    	}
		    	else
		    	{
		            
		    	
		    		this.productService.updateProduct(p);
		    		
		    	}
		    	return "registrationform";
		        
		    	}
		    */
		    @RequestMapping(value= "/editpage/{id}", method = RequestMethod.GET)
		    public String updateProduct(@PathVariable("id") int id,Model model,Product p)
		    	
		    {
		    	this.productService.updateProduct(p);
		    return "editpage";
		    }
		  
		    
		    @RequestMapping(value = "/myForm", method = RequestMethod.GET)

		    public String showForm(Map model) {

		        return "/myForm";

		    }

		 

		   
		}
		   
		    
	
		   