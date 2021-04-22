package com.accolite.oppmang.controllers;
import java.util.List;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.oppmang.dao.OpportunityDaoImpl;
import com.accolite.oppmang.models.Opportunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(path="/opportunity")
public class OpportunityController {
	
	@Autowired
	OpportunityDaoImpl opportunityDao;
	
	@GetMapping(path="/")
	public String check() {
		return "<h1>Welcome to Opportunity Management Backend App</h1>";
	}
	
	@GetMapping(path="getAll")
	public List <Opportunity> getAllOpportunities(){
		List <Opportunity> list = new ArrayList<>();
		list = opportunityDao.getAllOpportunities();
		return list;
	}
	
	@PostMapping(path="add",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int addOpportunity(@RequestBody Opportunity opportunity) {
		int val = opportunityDao.addOpportunity(opportunity);
		return val;
	}
	
	@PutMapping(path="edit/{id}")
	@ResponseBody
	public int updateOpportunity(@RequestBody Opportunity opportunity, @PathVariable("id") int id) {
		int val = opportunityDao.updateOpportunity(opportunity, id);
		return val;
	}
	
	@DeleteMapping(path="delete/{id}")
	@ResponseBody
	public int deleteOpportunity(@PathVariable("id") int id) {
		int val = opportunityDao.deleteOpportunity(id);
		return val;
	}
}
