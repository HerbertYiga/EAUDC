package com.eaudc.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eaudc.bean.PersonBean;
import com.eaudc.dao.UserDao;

@Controller
public class UserController {

	@Autowired

	UserDao userdao;

//end of kasules controllers

//list of person details basing on id

	@RequestMapping("viewPersonDetailsById")

	public ModelAndView viewPersonDetailsById(HttpServletRequest request,HttpSession session,@ModelAttribute("print") PersonBean personbean, Model model) {

		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != null) {
		
		
		if (personbean.getCheckedIds() != null) {

			List<PersonBean> list = userdao.getPersonDetailsById(personbean);

			model.addAttribute("list", list);

			return new ModelAndView("viewPersonDetailsById");

		}

		else
		{
			
			model.addAttribute("error","select cards for printing!!");
			List<PersonBean> list = userdao.getPersonDetails();

			return new ModelAndView("viewPersonDetails", "list", list);
			
		
		}
		
		}
		else
		{
			return new ModelAndView("opps");
		}
		
		
		

	}

//list of person details

	@RequestMapping("viewPersonDetails")

	public ModelAndView viewPersonDetails(HttpServletRequest request,HttpSession session) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != null) {

		List<PersonBean> list = userdao.getPersonDetails();

		return new ModelAndView("viewPersonDetails", "list", list);}
		
		
		return new ModelAndView("opps");

	}

	// saving the person details by the user

	@RequestMapping(value = "savePersonDetails")

	public ModelAndView savePersonalDetails(HttpServletRequest request, @ModelAttribute("person") PersonBean person) {

		// handling the images
		List<MultipartFile> files = person.getImages();

		List<String> fileNames = new ArrayList<String>();

		if ((files != null) && (files.size() > 0)) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				person.setImageLink(fileName);

				fileNames.add(fileName);

				File imagefile = new File(request.getServletContext().getRealPath("/resources/image"), fileName);
				try {
					multipartFile.transferTo(imagefile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			userdao.savePersonDetails(person);
		}

		return new ModelAndView("redirect:/viewPersonDetails");
	}

	// viewing the user panel
	@RequestMapping("UserPanel")

	public ModelAndView userPanel(HttpServletRequest request,HttpSession session,@ModelAttribute("person") PersonBean person) {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if (userId != null) {
		return new ModelAndView("UserPanel");}
		else
		{
			return new ModelAndView("opps");
		}

	}

}
