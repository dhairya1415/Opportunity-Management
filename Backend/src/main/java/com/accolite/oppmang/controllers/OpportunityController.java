package com.accolite.oppmang.controllers;
import java.util.List;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.dao.AuditDaoImpl;
import com.accolite.oppmang.dao.OpportunityDaoImpl;
import com.accolite.oppmang.models.Audit;
import com.accolite.oppmang.models.Opportunity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(path="/opportunity")
public class OpportunityController {
	
	@Autowired
	OpportunityDaoImpl opportunityDao;
	
	@Autowired
	AuditDaoImpl auditDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OpportunityController.class);
	
	@GetMapping(path="/")
	public String check() {
		logger.info("****Check method Opportunity Controller****");
		return "<h1>Welcome to Opportunity Management Backend App</h1>";
	}
	
	@GetMapping(path="getAll")
	public List <Opportunity> getAllOpportunities(){
		logger.info("****getAllOpportunities method Opportunity Controller****");
		List <Opportunity> list = new ArrayList<>();
		try {
			list = opportunityDao.getAllOpportunities();
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return list;
	}
	
	@GetMapping(path="get/{id}")
	public Opportunity getOpportunity(@PathVariable("id") int id){
		logger.info("****getOpportunity method Opportunity Controller****");
		Opportunity opportunity = new Opportunity();
		try {
			opportunity = opportunityDao.getOpportunity(id);
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return opportunity;
	}
	
	@GetMapping(path="getlast")
	public Opportunity getLastOpportunity(){
		logger.info("****getLastOpportunity method Opportunity Controller****");
		Opportunity opportunity = new Opportunity();
		try {
			opportunity = opportunityDao.getLastOpportunity();
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return opportunity;
	}
	
	@PostMapping(path="add",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int addOpportunity(@RequestBody Opportunity opportunity, @RequestHeader(value="user_email", required=false) String user_email, @RequestHeader(value="user_name", required=false) String user_name) {
		logger.info("****addOpportunity method Opportunity Controller****");
		int val = 0;
		try {
			val = opportunityDao.addOpportunity(opportunity);
			if(val == 1) {
				Opportunity after = opportunityDao.getLastOpportunity();
				int oppid = after.getOppid();
				Audit audit = new Audit(user_name, user_email, "Create", " ", after.toString(), oppid);
				auditDao.addAudit(audit);
			}
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return val;
	}
	
	@PutMapping(path="update/{id}")
	@ResponseBody
	public int updateOpportunity(@RequestBody Opportunity opportunity, @PathVariable("id") int id, @RequestHeader(value="user_email", required=false) String user_email, @RequestHeader(value="user_name", required=false) String user_name) {
		logger.info("****updateOpportunity method Opportunity Controller****");
		int val = 0;
		try {
			Opportunity before = opportunityDao.getOpportunity(id);
			val = opportunityDao.updateOpportunity(opportunity, id);
			if(val == 1) {
				Opportunity after = opportunityDao.getOpportunity(id);
				Audit audit = new Audit(user_name, user_email, "Update", before.toString(), after.toString(), id);
				auditDao.addAudit(audit);
			}
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return val;
	}
	
	@DeleteMapping(path="delete/{id}")
	@ResponseBody
	public int deleteOpportunity(@PathVariable("id") int id, @RequestHeader(value="user_email", required=false) String user_email, @RequestHeader(value="user_name", required=false) String user_name) {
		logger.info("****deleteOpportunity method Opportunity Controller****");
		int val = 0;
		try {
			Opportunity before = opportunityDao.getOpportunity(id);
			val = opportunityDao.deleteOpportunity(id);
			if(val == 1) {
				Audit audit = new Audit(user_name, user_email, "Delete", before.toString(), " ", id);
				auditDao.addAudit(audit);
			}
		} catch (DetailsNotFound e) {
			logger.error("DetailsNotFound Opportunity Controller");
		}
		return val;
	}
}
