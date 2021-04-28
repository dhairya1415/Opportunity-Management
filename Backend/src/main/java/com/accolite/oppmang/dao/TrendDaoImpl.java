package com.accolite.oppmang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.oppmang.models.Trend;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

@Component
public class TrendDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getYearCount() {
		String query = "select count(distinct(year(joining_date))) as count from opportunity";
		List <Integer> count = new ArrayList<>();
		jdbcTemplate.query(query, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				count.add(rs.getInt(1));
			}
		});
		return count.get(0);
	}
	
	public int getLocationCount() {
		String query = "select count(distinct(location)) as count from opportunity";
		List <Integer> count = new ArrayList<>();
		jdbcTemplate.query(query, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				count.add(rs.getInt(1));
			}
		});
		return count.get(0);
	}
	
	public int getSkillCount() {
		String query = "select count(distinct(skills)) as count from opportunity";
		List <Integer> count = new ArrayList<>();
		jdbcTemplate.query(query, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				count.add(rs.getInt(1));
			}
		});
		return count.get(0);
	}
	
	public Trend locationTrends(){
		int yearCount = this.getYearCount(), locationCount = this.getLocationCount();
		String query = "select year(joining_date), location, sum(demand) from opportunity group by year(joining_date), location;";
		Trend trend = new Trend();
		List <String> years = new ArrayList<>();
		List <String> columns = new ArrayList<>();
		long data[][] = new long[locationCount][yearCount];
		jdbcTemplate.query(query,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String year = rs.getString(1);
				String column = rs.getString(2);
				if(!years.contains(year)) {
					years.add(year);
				}
				if(!columns.contains(column)) {
					columns.add(column);
				}
				data[columns.indexOf(column)][years.indexOf(year)] = rs.getInt(3);
			}
			
		});
		trend.setYears(years);
		trend.setColumns(columns);
		trend.setData(data);
		return trend;
	}
	
	public Trend skillTrends(){
		int yearCount = this.getYearCount(), skillCount = this.getSkillCount();
		String query = "select year(joining_date), skills, sum(demand) from opportunity group by year(joining_date), skills;";
		Trend trend = new Trend();
		List <String> years = new ArrayList<>();
		List <String> columns = new ArrayList<>();
		long data[][] = new long[skillCount][yearCount];
		jdbcTemplate.query(query,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String year = rs.getString(1);
				String column = rs.getString(2);
				if(!years.contains(year)) {
					years.add(year);
				}
				if(!columns.contains(column)) {
					columns.add(column);
				}
				data[columns.indexOf(column)][years.indexOf(year)] = rs.getInt(3);
			}
			
		});
		trend.setYears(years);
		trend.setColumns(columns);
		trend.setData(data);
		return trend;
	}
	
	public Trend quarterTrends(){
		int yearCount = this.getYearCount(), quarterCount = 4;
		String query = "select year(joining_date), quarter(joining_date), sum(demand) from opportunity group by year(joining_date), quarter(joining_date);";
		Trend trend = new Trend();
		List <String> years = new ArrayList<>();
		List <String> columns = new ArrayList<>();
		long data[][] = new long[quarterCount][yearCount];
		jdbcTemplate.query(query,new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String year = rs.getString(1);
				String column = "Q" + rs.getString(2);
				if(!years.contains(year)) {
					years.add(year);
				}
				if(!columns.contains(column)) {
					columns.add(column);
				}
				data[columns.indexOf(column)][years.indexOf(year)] = rs.getInt(3);
			}
			
		});
		trend.setYears(years);
		trend.setColumns(columns);
		trend.setData(data);
		return trend;
	}
}
