package com.javatpoint.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;















import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.LoginBean;
import com.javatpoint.beans.Product;
import com.javatpoint.beans.clients;
import com.javatpoint.beans.userBean;
import com.javatpoint.beans.userlogin;
import com.javatpoint.dao.userDao;

@Controller
public class Pages {
	
	@Autowired(required=true)
	userDao dao;
	
	@RequestMapping(value="/aboutus")
     
	public String aboutus(){
		return "aboutus";
		
	}
    @RequestMapping(value="/userlogout")
    public String logoutuser(){
    	
    	
    	return "userlogin";
    }
	
	@RequestMapping(value="/admin")
	public String admin(){
		return "admin";
	}
	
	@RequestMapping("/adduser")
	public ModelAndView showform(){
		
		return new ModelAndView("adduser","command",new userBean());
		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	
	public  ModelAndView save(@ModelAttribute("userbean") @Validated userBean userbean,BindingResult bindingresult){
		if(bindingresult.hasErrors()){
			return new ModelAndView("adduser","command",new userBean());
		}
		
		
		
		dao.save(userbean);
		return new ModelAndView("redirect:/viewusers");}
	
	@RequestMapping("viewusers")
	public ModelAndView viewusers(){
			List<userBean> list=dao.getUsers();
		return new ModelAndView("viewusers","list",list);
			
	}
	@RequestMapping(value="/userloging")
	public ModelAndView viewuserlogin(){
		
		
		return new ModelAndView("userlogin","comman",new userlogin());
	}
	
	
	@RequestMapping(value="/usercheck",method=RequestMethod.POST)
	public ModelAndView  checkusers(userlogin loginbean,ModelMap model) throws ClassNotFoundException, SQLException{
		model.addAttribute("userlogin",new userlogin());
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost/delight","root","onlylord");
		String sql="select uname,password from users where  uname = '"+ loginbean.getUname() +"' and password='"+ loginbean.getPassword() +"'";
		

		Statement st=connection.createStatement();



		ResultSet rs=st.executeQuery(sql);



		if(rs.next()) {
			return  new ModelAndView ("userpanel");
				
			
		}

		else{
			
			return  new ModelAndView ("userlogin");
		
		
		}
		
		
		

		
		
	}
	
	//whats done incase of a url with edit and is
	
	
	@RequestMapping(value="/edituser/{id}")
	
	public ModelAndView edit(@PathVariable int id){
		
		userBean userbean=dao.getUserById(id);
		return new ModelAndView("usereditform","command",userbean);
		
		
		
	}
	//whats done in case of the action edit save
	@RequestMapping(value ="editsave",method=RequestMethod.POST)
	
	public ModelAndView editsave(@ModelAttribute("userbean") @Validated userBean userbean,BindingResult bindingresult){
		
		
		
		
		
		
		dao.update(userbean);
		return new ModelAndView("redirect:/viewusers");
	}
	//method for deleting the user 
	
	
	
	@RequestMapping(value="/deleteuser/{id}",method=RequestMethod.GET)
	
	
	public ModelAndView delete(@PathVariable int id){
		
		dao.delete(id);
		return new ModelAndView("redirect:/viewusers");
		
		
		
		
	}
	
	

	
	
	@RequestMapping(value="/adminloging")
	public ModelAndView viewadminlogin(){
		
		
		return new ModelAndView("adminlogin");
	}
	
	@RequestMapping(value="/logoutloging")
	
	public ModelAndView logout(){
		return new ModelAndView("/adminlogin");
		
		
		
	}
	//NAVIGATION OF THE USER 
	
	@RequestMapping("userdashbord")
	public ModelAndView userpanel(){
		
		return new ModelAndView("userpanel");
		
	}
	@RequestMapping("useraddproduct")
public ModelAndView useraddproduct(){
		
		return new ModelAndView("useraddproduct","command",new Product());
		
	}

	

}
