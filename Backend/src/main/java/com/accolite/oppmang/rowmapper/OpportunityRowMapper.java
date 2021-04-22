package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.models.Opportunity;

public class OpportunityRowMapper implements RowMapper<Opportunity>{

	@Override
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Opportunity opportunity = new Opportunity();
		opportunity.setOppid(rs.getInt("oppid"));
		opportunity.setManager_name(rs.getString("manager_name"));
		opportunity.setManager_email(rs.getString("manager_email"));
		opportunity.setDemand(rs.getInt("demand"));
		opportunity.setDescription(rs.getString("description"));
		opportunity.setLocation(rs.getString("location"));
		opportunity.setSkills(rs.getString("skills"));
		opportunity.setMin_exp(rs.getInt("min_exp"));
		opportunity.setJoining_date(rs.getDate("joining_date").toLocalDate());
		return opportunity;
	}

}
