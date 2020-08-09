package com.javatpoint.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatpoint.beans.LoginBean;





@Controller

public class LoginController {
	
	
	
	@RequestMapping(value="/loginadmin",method=RequestMethod.POST)
	public String submit(Model model,@ModelAttribute("loginBean") LoginBean loginBean){
		
		
		
		if( loginBean !=null&&loginBean.getUserName()!=null&loginBean.getPassword() !=null){
			
			if(loginBean.getUserName().equals("Admin")&&loginBean.getPassword().equals("admin123")){
				
				return ("admin");
			}
			else{model.addAttribute("error","Invalid details");
			return "adminlogin";
			}
			
			
			
		}
		
		else{
			
			
			model.addAttribute("error","please enter details");
			return ("adminlogin");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	//checking the user login just
	@RequestMapping(value="/usertest",method=RequestMethod.POST)
	public String userttest(Model model,@ModelAttribute("loginBean") LoginBean loginBean){
		
		
		
		if( loginBean !=null&&loginBean.getUserName()!=null&loginBean.getPassword() !=null){
			
			if(loginBean.getUserName().equals("user")&&loginBean.getPassword().equals("123")){
				
				return ("userpanel");
			}
			else{model.addAttribute("error","Invalid details");
			return "userlogin";
			}
			
			
			
		}
		
		else{
			
			
			model.addAttribute("error","please enter details");
			return ("userlogin");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
