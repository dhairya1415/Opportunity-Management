package com.accolite.oppmang.controllers;

import java.util.List;
import java.util.ArrayList;

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
	
	@GetMapping(path="locationSkills")
	public Trend locationSkillsTrends(){
		logger.info("****locationSkillsTrends method Trend Controller****");
		Trend locationSkills = new Trend();
		locationSkills = trendDao.locationSkillsTrends();
		return locationSkills;
	}
	
	@GetMapping(path="locationCount")
	public List < List <?> > locationCount(){
		logger.info("****locationCount method Trend Controller****");
		List < List <?> > locationCount = new ArrayList<>();
		locationCount = trendDao.locationCount();
		return locationCount;
	}
	
	@GetMapping(path="skillCount")
	public List < List <?> > skillCount(){
		logger.info("****skillCount method Trend Controller****");
		List < List <?> > skillCount = new ArrayList<>();
		skillCount = trendDao.skillCount();
		return skillCount;
	}
}
