package com.eaudc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.eaudc.bean.PersonBean;
import com.eaudc.bean.UserBean;
import com.mysql.jdbc.StringUtils;

public class UserDao {

	JdbcTemplate template;

	// setter method for the jdbc template
	public void setTemplate(JdbcTemplate template) {

		this.template = template;
	}
	
	
	
	
	public List<PersonBean> getPrintedCards() {

		return this.template.query("select persondetails.personId,persondetails.sirName,persondetails.otherName,persondetails.country,persondetails.category,persondetails.university from printedcards  INNER JOIN persondetails ON printedcards.personId=persondetails.personId ",
				new RowMapper<PersonBean>() {
					public PersonBean mapRow(ResultSet rs, int row) throws SQLException {

						 PersonBean  person = new  PersonBean ();


							person.setSirName(rs.getString("sirName"));

							person.setPersonId(rs.getInt("personId"));

							person.setOtherName(rs.getString("otherName"));

							person.setCountry(rs.getString("country"));

							person.setCategory(rs.getString("category"));

					
							person.setUniversity(rs.getString("university"));
							
					
							

						return person;
					}
				});
	}

	
	//getting the persondetails from the database basing on meal type and date
	public List<PersonBean> getMealDetails(PersonBean bean) {

		return this.template.query(
				"select persondetails.personId,persondetails.sirName,persondetails.otherName,persondetails.country,persondetails.category,persondetails.imageLink,persondetails.university,archive.date,archive.mealType from archive INNER JOIN persondetails ON (archive.personId=persondetails.personId) WHERE archive.date='" + bean.getDate() +"' AND archive.mealType='" + bean.getMealType() +"'  ORDER BY archive.archiveId DESC",
				new RowMapper<PersonBean>() {
					public PersonBean mapRow(ResultSet rs, int row) throws SQLException {

						PersonBean person = new PersonBean();

						person.setSirName(rs.getString("sirName"));

						person.setPersonId(rs.getInt("personId"));

						person.setOtherName(rs.getString("otherName"));

						person.setCountry(rs.getString("country"));

						person.setCategory(rs.getString("category"));

						person.setImageLink(rs.getString("imageLink"));
						person.setUniversity(rs.getString("university"));
						
						person.setDate(rs.getString("date"));
						
						person.setMealType(rs.getString("mealType"));
						return person;
					}
				});
	}

	//selecting the date from the archive
	// get user details
		public List<PersonBean> getDate() {

			return this.template.query(
					"select date,MAX(archiveId) from archive GROUP BY date",
					new RowMapper<PersonBean>() {
						public PersonBean mapRow(ResultSet rs, int row) throws SQLException {

							 PersonBean  thedate = new  PersonBean ();

							 thedate.setDate(rs.getString("date"));

							return thedate;
						}
					});
		}
	
	
	
	
	
	
	//getting the confirmation details by id
	
	public PersonBean getConfirmationDetailsById(int id) {

		try {

			String sql = "select * from confirmation where personId=?";
			return template.queryForObject(sql, new Object[] { id },
					new BeanPropertyRowMapper<PersonBean>(PersonBean.class));

		}

		catch (Exception e) {

			return null;
		}

	}
	
	//saving the confirmation details on those whow have taken meals
	


	public void  saveMealTypes(final PersonBean personbean){
		 //Getting the last generated id using  Genrated Key Holder
		     GeneratedKeyHolder holder = new GeneratedKeyHolder();
		     
		     template.update(new PreparedStatementCreator() {
		    	    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		    	        PreparedStatement statement = con.prepareStatement("insert into confirmation (personId,date,mealType) values(?,?,?) ", Statement.RETURN_GENERATED_KEYS);
		    	        statement.setInt(1,  personbean.getPersonId());
		    	        statement.setString(2,personbean.getDate() );
		    	        statement.setString(3, personbean.getMealType());
		    	        
		    	        return statement;
		    	    }
		    	}, holder);
		     
		  
			  
			  String sql2="insert into archive (personId,date,mealType) values( '"+ personbean.getPersonId() +"', '"+ personbean.getDate() +"','"+ personbean.getMealType() +"')";
			   
		
		       template.update(sql2);
		
		
		
		
	}
	
	
	
	
	// getting the person details by id

	public PersonBean getPersonDetailsById(int id) {

		try {

			String sql = "select persondetails.personId,persondetails.sirName,persondetails.otherName,persondetails.country,persondetails.category,persondetails.imageLink,persondetails.university from printedcards  INNER JOIN persondetails ON printedcards.personId=persondetails.personId where printedcards.personId=?";
			return template.queryForObject(sql, new Object[] { id },
					new BeanPropertyRowMapper<PersonBean>(PersonBean.class));

		}

		catch (Exception e) {

			return null;
		}

	}

	// inserting a list to the database(printed card ids)

	public void insertBatch(final List<Integer> ids) {

		String sql = "insert into printedcards (personId)  values(?)";

		template.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				PersonBean bean = new PersonBean();
				Integer id = ids.get(i);
				bean.setPersonId(id);
				ps.setInt(1, bean.getPersonId());

			}

			public int getBatchSize() {

				return ids.size();
			}

		});

	}

	// viewing person details as list by id
	public List<PersonBean> getPersonDetailsById(PersonBean personbean) {

		Integer[] ids = personbean.getCheckedIds();
		List<Integer> list = new ArrayList<Integer>();
		for (Integer id : ids) {
			list.add(id);

		}

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(template);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ids", list);

		List<PersonBean> list2 = namedParameterJdbcTemplate.query(
				"SELECT * FROM persondetails where  personId IN (:ids)", params,
				ParameterizedBeanPropertyRowMapper.newInstance(PersonBean.class));

		return list2;

	}

	// method for listing PersonDetails
	// method for listing PersonDetails
	public List<PersonBean> getPersonDetails() {

		return this.template.query(
				"select persondetails.personId,persondetails.sirName,persondetails.otherName,persondetails.country,persondetails.category,persondetails.imageLink,persondetails.university from persondetails LEFT OUTER JOIN printedcards ON(persondetails.personId=printedcards.personId) WHERE printedcards.personId IS NULL ORDER BY persondetails.personId DESC",
				new RowMapper<PersonBean>() {
					public PersonBean mapRow(ResultSet rs, int row) throws SQLException {

						PersonBean person = new PersonBean();

						person.setSirName(rs.getString("sirName"));

						person.setPersonId(rs.getInt("personId"));

						person.setOtherName(rs.getString("otherName"));

						person.setCountry(rs.getString("country"));

						person.setCategory(rs.getString("category"));

						person.setImageLink(rs.getString("imageLink"));
						person.setUniversity(rs.getString("university"));
						return person;
					}
				});
	}

	// saving the person details

	public int savePersonDetails(PersonBean personbean) {

		String sql = "insert into personDetails(sirName,otherName,country,category,imageLink,university) values('"
				+ personbean.getSirName() + "','" + personbean.getOtherName() + "','" + personbean.getCountry() + "','"
				+ personbean.getCategory() + "','" + personbean.getImageLink() + "','" + personbean.getUniversity()
				+ "')";

		return this.template.update(sql);

	}

}
