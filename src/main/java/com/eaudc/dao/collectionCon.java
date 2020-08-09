package com.javatpoint.controllers;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Product;
import com.javatpoint.beans.clients;
import com.javatpoint.beans.collection;
import com.javatpoint.beans.userBean;
import com.javatpoint.dao.collectionD;
import com.javatpoint.dao.productDao;





@Controller
public class collectionCon {
	
    @Autowired(required=true)
	collectionD ldao;
	//viewiing the collection
		@RequestMapping("collection")
		
		public ModelAndView viewCollection(Model model){
			model.addAttribute("collection",new collection());
			List<collection>list=ldao.getCollection();
			
			return new ModelAndView("collection","list",list);
		
			
		}
		
		@RequestMapping("viewcart")
		
		
		public ModelAndView viewcollection(collection cartcollection,ModelMap model,ModelMap countmodel){
			
			List<collection>list=ldao.addAndviewCart(cartcollection,model,countmodel);
			return new ModelAndView("cart","list",list);
		
			
		}

		@RequestMapping("clientorderdetails")
		public ModelAndView clientorderdetails(collection cartcollection,ModelMap model,ModelMap countmodel,clients myclients ){
			
			ldao.saveorderandclientdetails(cartcollection,model,countmodel,myclients);
			return new ModelAndView("clientorderdetails","command",new clients());
		}
		
	
	
	
	
	@RequestMapping("saveorderandclientdetails")
	
	@Transactional
	
	
	public String saveclientdetails(clients myclients){
		ldao.saveclients(myclients);
		return "submited";
		
		
	}
	
	
	
	
	
	@RequestMapping("viewodersandclientdetails")
	
	public ModelAndView viewOrders(ModelMap modelmap){
		List<clients>list1=ldao.getClients();
		modelmap.addAttribute("list2",list1);
		
		List<collection>list=ldao.getOders();
		
		return new ModelAndView("oders","list",list);
	
		
	}
	
	//view orders by user
	
	@RequestMapping("viewodersandclientdetailsbyuser")
	
	public ModelAndView viewOrdersByUser(ModelMap modelmap){
		List<clients>list1=ldao.getClients();
		modelmap.addAttribute("list2",list1);
		
		List<collection>list=ldao.getOders();
		
		return new ModelAndView("userviewoforders","list",list);
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
