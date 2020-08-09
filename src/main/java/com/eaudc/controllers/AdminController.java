package com.eaudc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eaudc.bean.UserBean;
import com.eaudc.dao.AdminDao;

@Controller

public class AdminController {

	// admin
	@Autowired
	AdminDao admindao;

	// changePasswordView

	@RequestMapping("updatePassword")

	public ModelAndView updatePassword() {

		return new ModelAndView("redirect:/ChangeUserPasswords");
	}

	// change passord page view
	@RequestMapping(value = "/changepassword/{id}", method = RequestMethod.GET)

	public ModelAndView changePassword(HttpServletRequest request,HttpSession session,@PathVariable int id, @ModelAttribute("edituser") UserBean edituser,
			Model model) {
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
		UserBean user = admindao.getUserById(id);
		model.addAttribute("user", user);

		return new ModelAndView("changePasswordView");}
		else
		return new ModelAndView("opps");
	}

	// viewing the saved users
	@RequestMapping("ChangeUserPasswords")
	public ModelAndView viewUserPasswords(HttpServletRequest request,HttpSession session,UserBean userbean) {
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
		List<UserBean> list = admindao.getUserDetails();

		return new ModelAndView("ChangeUserPasswords", "list", list);}
		
		else
		return new ModelAndView("opps");

	}

	// Enabling users
	@RequestMapping("viewUsersForEnable")
	public ModelAndView viewUsersForEnable(HttpServletRequest request,HttpSession session,UserBean userbean) {
		
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
		List<UserBean> list = admindao.getUserDetails();

		return new ModelAndView("viewUsersForEnable", "list", list);
		}
		return new ModelAndView("opps");
	}
	// Enabling the user

	@RequestMapping(value = "/enableuser/{userId}", method = RequestMethod.GET)

	public ModelAndView enableUsers(@PathVariable int userId, @ModelAttribute("edituser") UserBean edituser,
			Model model) {

		admindao.enableUser(userId);

		return new ModelAndView("redirect:/viewUsersForEnable");

	}

	// Disable users

	@RequestMapping(value = "/disableuser/{userId}", method = RequestMethod.GET)

	public ModelAndView DiableUsers(@PathVariable int userId, @ModelAttribute("edituser") UserBean edituser,
			Model model) {

		admindao.disableUser(userId);

		return new ModelAndView("redirect:/viewUsersForEnable");
	}

	// updating use details
	@RequestMapping(value = "updateDetails")
	public ModelAndView updateUsers(UserBean userdetails) {
		admindao.update(userdetails);

		return new ModelAndView("redirect:/viewUsers");
	}

	// edit form
	@RequestMapping("editUserDetailsForm")
	public ModelAndView editUserDetials(HttpServletRequest request,HttpSession session) {
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {

		return new ModelAndView("editUserDetailsForm");}
		
		return  new ModelAndView("opps");
	}

	// getting the user details from the users and users_roles databases by id for
	// editing
	@RequestMapping(value = "/edituserdetails/{id}", method = RequestMethod.GET)

	public ModelAndView editUserDetails(HttpServletRequest request,HttpSession session,@PathVariable int id, @ModelAttribute("edituser") UserBean edituser,
			Model model) {
		
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
		UserBean user = admindao.getUserById(id);
		model.addAttribute("user", user);

		return new ModelAndView("editUserDetailsForm");}
		
		else
			return new ModelAndView("opps");
	}

	// viewing the saved users
	@RequestMapping("viewUsers")
	public ModelAndView viewUsers(HttpServletRequest request,HttpSession session,UserBean userbean) {
		
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
		List<UserBean> list = admindao.getUserDetails();

		return new ModelAndView("viewUsers", "list", list);}
		
		
		else 
			
			return new ModelAndView("opps");

	}

	// saving user details
	@RequestMapping("saveuserdetails")
	public ModelAndView saveUsers(UserBean userbean) {

		// save the user details

		admindao.saveUserDetails(userbean);

		return new ModelAndView("redirect:/viewUsers");

	}

	@RequestMapping("AdminPanel")
	public ModelAndView AdminPanel(HttpServletRequest request, HttpSession session,
			@ModelAttribute("adduser") UserBean userbean) {
		String adminId = (String) request.getSession().getAttribute("adminId");
		if (adminId != null) {
			return new ModelAndView("AdminPanel");

		} else
			return new ModelAndView("opps");

	}

}
