package com.javatpoint.controllers;


import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.beans.Product;
import com.javatpoint.beans.userBean;
import com.javatpoint.dao.productDao;





@Controller
public class ProductController {
	
    @Autowired(required=true)
	productDao pdao;
	
	
	
	@RequestMapping(value="/addProduct")
	
	public ModelAndView addProduct(){
		
		
		return new ModelAndView("addProduct","command",new Product());
	}
	//viewiing the products
		@RequestMapping("viewProducts")
		
		public ModelAndView viewProducts(){
			List<Product>list=pdao.getProducts();
			return new ModelAndView("viewProducts","list",list);
		
			
		}
@RequestMapping("viewProductsByUser")
		
		public ModelAndView viewProductByUser(){
	         
	        
			List<Product>list=pdao.getProducts();
			return new ModelAndView("viewProductsByUser","list",list);
			}
	        
		
			
		
		
		
	
			
	@RequestMapping(value="/save-product",method=RequestMethod.POST)
	
	public ModelAndView  saveproduct(HttpServletRequest servletRequest, @ModelAttribute("product") @Validated Product product,BindingResult bindingresult,Model model) {
		
		if(bindingresult.hasErrors()){
			return new ModelAndView("addProduct","command",new Product());
		}
		
		
	//get uploaded files and store all of them
		
		List <MultipartFile>files=product.getImages();
		
		List<String>fileNames=new ArrayList<String>();
		if(null!=files&&files.size()>0){
			for(MultipartFile multipartFile:files){
				
				
				
				String fileName=multipartFile.getOriginalFilename();
				
				//using the bean to set the value of image data
				product.setData(fileName);
				fileNames.add(fileName);
				File imagefile=new File(servletRequest.getServletContext().getRealPath("/resources/image"),fileName);
				try{
					multipartFile.transferTo(imagefile);
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				
				
			}
			
			
			
		
			//inserting the products details to the data base
			pdao.prouctsave(product);
			
			
			
			
			
		}
		
		return new ModelAndView("redirect:/viewProducts");
		
	}
	//USER ADDING THE PRODUCT
@RequestMapping(value="/save-productbyuser",method=RequestMethod.POST)
	
	public ModelAndView  saveproductbyuser(HttpServletRequest servletRequest, @ModelAttribute("product") @Validated Product product,BindingResult bindingresult,Model model) {
		
		
		if(bindingresult.hasErrors()){
			return new ModelAndView("useraddproduct","command",new Product());
		}
		
	//get uploaded files and store all of them
		
		List <MultipartFile>files=product.getImages();
		
		List<String>fileNames=new ArrayList<String>();
		if(null!=files&&files.size()>0){
			for(MultipartFile multipartFile:files){
				
				
				
				String fileName=multipartFile.getOriginalFilename();
				
				//using the bean to set the value of image data
				product.setData(fileName);
				fileNames.add(fileName);
				File imagefile=new File(servletRequest.getServletContext().getRealPath("/resources/image"),fileName);
				try{
					multipartFile.transferTo(imagefile);
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				
				
			}
			
			
			
		
			//inserting the products details to the data base
			pdao.prouctsave(product);
			
			
			
			
			
		}
		
		return new ModelAndView("redirect:/viewProductsByUser");
		
	}
	
	
	//method for editin the product
	
	
	@RequestMapping(value="/editproduct/{id}")
	
	public ModelAndView edit(@PathVariable int id){
		
		Product product=pdao.getProductById(id);
		return new ModelAndView("editProduct","command",product);
		
	}
	//user editing the product
@RequestMapping(value="/editproductbyuser/{id}")
	
	public ModelAndView editproductbyuser(@PathVariable int id){
		
		Product product=pdao.getProductById(id);
		return new ModelAndView("editProductByUser","command",product);
		
	}
	
	//saving after editing
	@RequestMapping(value="producteditsave",method=RequestMethod.POST)
	public ModelAndView producteditsave(@ModelAttribute("product") Product product){
		
		pdao.update(product);
		return new ModelAndView("redirect:/viewProducts");
		
		
	}
	
	//saving after editing
		@RequestMapping(value="producteditsavebyuser",method=RequestMethod.POST)
		public ModelAndView producteditsavebyuser(@ModelAttribute("product") Product product){
			
			pdao.update(product);
			return new ModelAndView("redirect:/viewProductsByUser");
			
			
		}
	
	
	//method for deleting the product
	@RequestMapping(value="/deleteproduct/{id}",method=RequestMethod.GET)
	
	public ModelAndView delete(@PathVariable int id){
		
		
		pdao.delete(id);
	
		return new ModelAndView("redirect:/viewProductsByUser");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
