package com.eaudc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.eaudc.bean.UserBean;

public class AdminDao {

	JdbcTemplate template;
	//cleaning the confirmation database

	// setter method for the jdbc template
	public void setTemplate(JdbcTemplate template) {

		this.template = template;
	}
	
	//deleting items from the database
	
	
	 //delete from the users and users_roles database
    public int deleteConfirmationDetails(){
	
	String sql="delete from confirmation ";

	return template.update(sql);
   }
	// updating password

	public int updatePassword(UserBean userdetails) {

		String sql = "update users set password='" + userdetails.getPassword() + "' where userId="
				+ userdetails.getUserId() + " ";

		return template.update(sql);

	}

	// enabling the users
	public int enableUser(int userId) {

		String sql = "update users set enable=1 WHERE userId=" + userId + "";

		return template.update(sql);

	}

	// disabling the users
	public int disableUser(int userId) {

		String sql = "update users set enable=0 WHERE userId=" + userId + "";

		return template.update(sql);

	}
	// getting the user by id

	public UserBean getUserById(int id) {

		String sql = "select * from users where userId=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	// updating the users

	// Method for updating the details
	public int update(UserBean userdetails) {
		String sql = "update users INNER JOIN users_roles on users.userId=users_roles.userId set users.userName='"
				+ userdetails.getUserName() + "',users_roles.authority='" + userdetails.getAuthority()
				+ "',users.phoneNumber='" + userdetails.getPhoneNumber() + "',users.email='" + userdetails.getEmail()
				+ "',users.fullName='" + userdetails.getFullName() + "' WHERE users.userId=" + userdetails.getUserId()
				+ " ";

		return template.update(sql);

	}


	// get user details
	public List<UserBean> getUserDetails() {

		return this.template.query(
				"select users.fullName,users.userId,users.userName,users.password,users.phoneNumber,users.email,users.fullName,users_roles.authority from users INNER JOIN users_roles ON users.userId=users_roles.userId ORDER BY userId DESC",
				new RowMapper<UserBean>() {
					public UserBean mapRow(ResultSet rs, int row) throws SQLException {

						UserBean users = new UserBean();

						users.setFullName(rs.getString("fullName"));

						users.setUserId(rs.getInt("userId"));

						users.setUserName(rs.getString("userName"));

						users.setPassword(rs.getString("password"));

						users.setPhoneNumber(rs.getInt("phoneNumber"));

						users.setEmail(rs.getString("email"));

						users.setAuthority(rs.getString("authority"));

						return users;
					}
				});
	}
	// saving to users and users_roles

	public void saveUserDetails(final UserBean userdetails) {
		// Getting the last generated id using Genrated Key Holder
		GeneratedKeyHolder holder = new GeneratedKeyHolder();

		template.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(
						"insert into users (userName,password,phoneNumber,enable,email,fullName) values(?,?,?,?,?,?) ",
						Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, userdetails.getUserName());
				statement.setString(2, userdetails.getPassword());
				statement.setInt(3, userdetails.getPhoneNumber());
				statement.setString(4, userdetails.getEnable());
				statement.setString(5, userdetails.getEmail());
				statement.setString(6, userdetails.getFullName());

				return statement;
			}
		}, holder);

		// storing the last generated id to int
		final long generateuserid = holder.getKey().longValue();
		userdetails.setUserId((int) generateuserid);
		String sql2 = "insert into users_roles (userId,authority) values( '" + userdetails.getUserId() + "', '"
				+ userdetails.getAuthority() + "')";

		template.update(sql2);

	}

}
