package com.project.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.project.model.ExternalModel;

public class ExternalDao {

	JdbcTemplate template;

	// setter method for the jdbc template
	public void setTemplate(JdbcTemplate template) {

		this.template = template;
	}

	public void saveVotes(final ExternalModel externalModel) {

		String sql = "insert into votes(internationalgrc,privategrc,governmentgrc,pwdgrc,eveningrc,nonresidencegrc,coordinatorgrc,facultygrc,hallchair,guild,time,hallgrc)"
				+ " values( '"
				+ externalModel.getInternationalgrc() + "', '"

				+ externalModel.getPrivategrc() + "','"

				+ externalModel.getGovernmentgrc() + "','"

				+ externalModel.getPwdgrc() + "','"

				+ externalModel.getEveningrc() + "','"

				+ externalModel.getNonresidencegrc() + "','"

				+ externalModel.getCoordinatorgrc() + "','"

				+ externalModel.getFacultygrc() + "','"

				+ externalModel.getHallchair() + "','"

				+ externalModel.getGuild() + "','"

				+ externalModel.getTime() + "','"

				+ externalModel.getHallgrc() + "')";

		template.update(sql);

	}

}
