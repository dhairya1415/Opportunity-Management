package com.accolite.oppmang.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.oppmang.dao.TrendDaoImpl;
import com.accolite.oppmang.models.Trend;

@RestController
@RequestMapping(path="/trends")
public class TrendController {
	@Autowired
	TrendDaoImpl trendDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TrendController.class);
	
	@GetMapping(path="locationTrends")
	public Trend locationTrends(){
		logger.info("****locationTrends method Trend Controller****");
		Trend locationTrends = new Trend();
		locationTrends = trendDao.locationTrends();
		return locationTrends;
	}
	
	@GetMapping(path="skillTrends")
	public Trend skillTrends(){
		logger.info("****locationTrends method Trend Controller****");
		Trend locationTrends = new Trend();
		locationTrends = trendDao.skillTrends();
		return locationTrends;
	}
	
	@GetMapping(path="quarterTrends")
	public Trend quarterTrends(){
		logger.info("****locationTrends method Trend Controller****");
		Trend locationTrends = new Trend();
		locationTrends = trendDao.quarterTrends();
		return locationTrends;
	}
	
	@GetMapping(path="yearCount")
	public int yearCount(){
		logger.info("****yearCount method Trend Controller****");
		return trendDao.getYearCount();
	}
	
	@GetMapping(path="locationCount")
	public int locationCount(){
		logger.info("****yearCount method Trend Controller****");
		return trendDao.getLocationCount();
	}
	
	@GetMapping(path="skillCount")
	public int skillCount(){
		logger.info("****yearCount method Trend Controller****");
		return trendDao.getSkillCount();
	}
}
