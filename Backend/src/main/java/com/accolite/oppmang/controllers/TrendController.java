package com.accolite.oppmang.controllers;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.oppmang.dao.TrendDaoImpl;

@RestController
@RequestMapping(path="/trends")
public class TrendController {
	@Autowired
	TrendDaoImpl trendDao;
	
	private static final Logger logger = LoggerFactory.getLogger(TrendController.class);
	
	@GetMapping(path="locationTrends")
	public List < List<?> > locationTrends(){
		logger.info("****locationTrends method Trend Controller****");
		List < List<?> > locationLists = new ArrayList<>();
		locationLists = trendDao.locationTrends();
		return locationLists;
	}
	
	@GetMapping(path="skillTrends")
	public List < List<?> > skillTrends(){
		logger.info("****skillTrends method Trend Controller****");
		List < List<?> > skillLists = new ArrayList<>();
		skillLists = trendDao.skillTrends();
		return skillLists;
	}
}
