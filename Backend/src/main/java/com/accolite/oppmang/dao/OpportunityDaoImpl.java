package com.accolite.oppmang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Opportunity;
import com.accolite.oppmang.rowmapper.OpportunityRowMapper;

import java.util.List;
import java.util.ArrayList;

@Repository("OpportunityDao")
@Transactional
public class OpportunityDaoImpl implements OpportunityDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List <Opportunity> getAllOpportunities() throws DetailsNotFound{
		List <Opportunity> oppList = new ArrayList<>();
		try {
			String query = "select * from opportunity order by joining_date desc";
			oppList = jdbcTemplate.query(query, new OpportunityRowMapper());
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return oppList;
	}
	
	@Override
	public List <Opportunity> getActiveOpportunities() throws DetailsNotFound{
		List <Opportunity> oppList = new ArrayList<>();
		try {
			String query = "select * from opportunity where joining_date >= curDate() and deleted=false order by joining_date desc";
			oppList = jdbcTemplate.query(query, new OpportunityRowMapper());
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return oppList;
	}
	
	@Override
	public List <Opportunity> searchOpportunities(String options) throws DetailsNotFound{
		List <Opportunity> oppList = new ArrayList<>();
		String query = "";
		try {
			if(options.charAt(options.length() - 1) == '1') {
				String location = options.substring(0, options.length() - 1);
				query = "select * from opportunity where location like '%"+location+"%' and joining_date >= curDate() and deleted=false";
			} else if(options.charAt(0) == '1') {
				String skill = options.substring(1);
				query = "select * from opportunity where skills like '%"+skill+"%' and joining_date >= curDate() and deleted=false";
			} else {
				String parts[] = options.split("1");
				query = "select * from opportunity where location like '"+parts[0]+"' and skills like '"+parts[1]+"' and joining_date >= curDate() and deleted=false";
			}
			oppList = jdbcTemplate.query(query, new OpportunityRowMapper());
		} catch (Exception e) {
			throw e;
		}
		return oppList;
	}
	
	@Override
	public List <String> getLocations() throws DetailsNotFound{
		List <String> locations = new ArrayList<>();
		try {
			String query = "select distinct(location) from opportunity";
			locations = jdbcTemplate.queryForList(query, String.class);
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return locations;
	}
	
	@Override
	public List <String> getSkills() throws DetailsNotFound{
		List <String> skills = new ArrayList<>();
		try {
			String query = "select distinct(skills) from opportunity";
			skills = jdbcTemplate.queryForList(query, String.class);
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return skills;
	}
	
	@Override
	public Opportunity getOpportunity(int id) throws DetailsNotFound{
		Opportunity opportunity = null;
		try {
			String query = "select * from opportunity where oppid="+id;
			opportunity = jdbcTemplate.queryForObject(query, new OpportunityRowMapper());
		} catch(Exception e) {
			throw (DetailsNotFound)e;
		}
		return opportunity;
	}
	
	@Override
	public Opportunity getLastOpportunity() throws DetailsNotFound{
		Opportunity opportunity = null;
		try {
			String query = "select * from opportunity where oppid=(select max(oppid) from opportunity)";
			opportunity = jdbcTemplate.queryForObject(query, new OpportunityRowMapper());
		} catch(Exception e) {
			throw (DetailsNotFound)e;
		}
		return opportunity;
	}
	
	@Override
	public int addOpportunity(Opportunity opportunity) {
		String query = "insert INTO opportunity (manager_name, manager_email, description, location, skills, min_exp, demand, joining_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(query, new Object[] {opportunity.getManager_name(), opportunity.getManager_email(), opportunity.getDescription(), opportunity.getLocation(), opportunity.getSkills(), opportunity.getMin_exp(), opportunity.getDemand(), opportunity.getJoining_date()});
		return rowsAffected;
	}
	
	@Override
	public int updateOpportunity(Opportunity opportunity, int id) {
		String query = "update opportunity set manager_name=?, manager_email=?, description=?, location=?, skills=?, min_exp=?, demand=?, joining_date=? where oppid="+id;
		int rowsAffected = jdbcTemplate.update(query, new Object[] {opportunity.getManager_name(), opportunity.getManager_email(), opportunity.getDescription(), opportunity.getLocation(), opportunity.getSkills(), opportunity.getMin_exp(), opportunity.getDemand(), opportunity.getJoining_date()});
		return rowsAffected;
	}
	
	@Override
	public int deleteOpportunity(int id) {
		String query = "update opportunity set deleted=true where oppid="+id;
		int rowsAffected = jdbcTemplate.update(query);
		return rowsAffected;
	}
}
