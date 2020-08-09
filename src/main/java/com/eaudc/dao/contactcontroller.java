package com.javatpoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.contact;
import com.javatpoint.dao.contactusDAO;


@Controller
public class contactcontroller {
	@Autowired
	contactusDAO cdao;

@RequestMapping(value="/contact us")

public ModelAndView contactus(){
	
	
	return new ModelAndView("contact us","command",new contactusDAO());
}




@RequestMapping(value="/savecontacinfo",method=RequestMethod.POST)
public ModelAndView savecontactinfo(@ModelAttribute("cont") contact cont){
	cdao.contactinfo(cont);
	return new ModelAndView("aftersubmittingcontactinfo");
	
	
}
	
	
	

}
