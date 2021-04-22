package com.accolite.oppmang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.oppmang.models.Opportunity;
import com.accolite.oppmang.rowmapper.OpportunityRowMapper;

import java.util.List;

@Component
public class OpportunityDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List <Opportunity> getAllOpportunities(){
		List <Opportunity> oppList;
		String query = "select * from opportunity";
		oppList = jdbcTemplate.query(query, new OpportunityRowMapper());
		return oppList;
	}
	
	public int addOpportunity(Opportunity opportunity) {
		String query = "INSERT INTO opportunity (manager_name, manager_email, description, location, skills, min_exp, demand, joining_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(query, new Object[] {opportunity.getManager_name(), opportunity.getManager_email(), opportunity.getDescription(), opportunity.getLocation(), opportunity.getSkills(), opportunity.getMin_exp(), opportunity.getDemand(), opportunity.getJoining_date()});
		return rowsAffected;
	}
	
	public int updateOpportunity(Opportunity opportunity, int id) {
		String query = "update opportunity set manager_name=?, manager_email=?, description=?, location=?, skills=?, min_exp=?, demand=?, joining_date=? where oppid="+id;
		int rowsAffected = jdbcTemplate.update(query, new Object[] {opportunity.getManager_name(), opportunity.getManager_email(), opportunity.getDescription(), opportunity.getLocation(), opportunity.getSkills(), opportunity.getMin_exp(), opportunity.getDemand(), opportunity.getJoining_date()});
		return rowsAffected;
	}
	
	public int deleteOpportunity(int id) {
		String query = "delete from opportunity where oppid=?";
		int rowsAffected = jdbcTemplate.update(query, new Object[] {id});
		return rowsAffected;
	}
}
