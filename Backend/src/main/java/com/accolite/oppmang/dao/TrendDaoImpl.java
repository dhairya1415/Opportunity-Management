package com.accolite.oppmang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

@Component
public class TrendDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List < List<?> > locationTrends(){
		String query = "select location, sum(demand) from opportunity group by location;";
		List < List<?> > locationLists = new ArrayList<>();
		List <String> locations = new ArrayList<>();
		List <Integer> demands = new ArrayList<>();
		jdbcTemplate.query(query,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				locations.add(rs.getString(1));
				demands.add(rs.getInt(2));
				
				while(rs.next())
				{
					locations.add(rs.getString(1));
					demands.add(rs.getInt(2));
				}
			}
			
		});
		locationLists.add(locations);
		locationLists.add(demands);
		return locationLists;
	}
	
	public List < List<?> > skillTrends(){
		String query = "select skills, sum(demand) from opportunity group by skills;";
		List < List<?> > locationLists = new ArrayList<>();
		List <String> skills = new ArrayList<>();
		List <Integer> demands = new ArrayList<>();
		jdbcTemplate.query(query,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				skills.add(rs.getString(1));
				demands.add(rs.getInt(2));
				
				while(rs.next())
				{
					skills.add(rs.getString(1));
					demands.add(rs.getInt(2));
				}
			}
			
		});
		locationLists.add(skills);
		locationLists.add(demands);
		return locationLists;
	}
}
