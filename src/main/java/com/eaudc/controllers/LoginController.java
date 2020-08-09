package com.eaudc.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eaudc.bean.UserBean;

@Controller

public class LoginController {

	// Logout
	@RequestMapping("Logout")

	public ModelAndView LogOut(HttpServletRequest request, HttpSession session) {

		session.invalidate();
		return new ModelAndView("Login");

	}

	// authenicating the user login

	@RequestMapping("checkUser")

	public ModelAndView checkUser(HttpServletRequest request, HttpSession session, UserBean user, Model model)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eaudc", "root", "onlylord");

		String sql = "select userId,userName,password,phoneNumber,enable,email,fullName from users where userName = '"
				+ user.getUserName() + "' and  password='" + user.getPassword() + "'";

		Statement st = connection.createStatement();

		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			UserBean userdetails = new UserBean();

			userdetails.setUserId(Integer.valueOf(rs.getInt("userId")));

			session.setAttribute("userId", userdetails.getUserId());

			userdetails.setUserName(rs.getString("userName"));

			userdetails.setFullName(rs.getString("fullName"));

			session.setAttribute("fullName", userdetails.getFullName());

			return new ModelAndView("redirect:/UserPanel");
		}

		if (((user.getPassword().equals("eaudc123")) && ((user.getUserName().equals("Admin"))))) {

			session.setAttribute("adminId", user.getPassword());

			return new ModelAndView("redirect:/AdminPanel");

		}

		else {

			model.addAttribute("error", "please insertt a correct user name and password");

			return new ModelAndView("Login");
		}

	}

	// login page
	@RequestMapping("Login")

	public ModelAndView Login() {

		return new ModelAndView("Login");

	}

}
