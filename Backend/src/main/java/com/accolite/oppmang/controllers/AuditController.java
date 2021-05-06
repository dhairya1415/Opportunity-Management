package com.accolite.oppmang.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.oppmang.models.Audit;
import com.accolite.oppmang.dao.AuditDaoImpl;
import com.accolite.oppmang.exception.DetailsNotFound;

@RestController
@RequestMapping(path="/audit")
public class AuditController {
	
	@Autowired
	AuditDaoImpl auditDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AuditController.class);
	
	@GetMapping(path="getAll")
	public List <Audit> getAllAudit(){
		logger.info("****getAllAudit method Audit Contoller****");
		List <Audit> auditList = null;
		try {
			auditList = auditDao.getAllAudit();
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			logger.error("****DetailsNotFound Audit Controller****");
		}
		return auditList;
	}
	
	@GetMapping(path="search/{key}/{value}")
	public List <Audit> searchAudits(@PathVariable("key") String key, @PathVariable("value") String value){
		logger.info("****searchAudits method Audit Contoller****");
		List <Audit> auditList = null;
		try {
			auditList = auditDao.searchAudits(key, value);
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			logger.error("****DetailsNotFound Audit Controller****");
		}
		return auditList;
	}
	
	@PostMapping(path="add",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int addAudit(@RequestBody Audit audit, @RequestHeader(value="user_email", required=false) String user_email, @RequestHeader(value="user_name", required=false) String user_name) {
		logger.info("****addAudit method Opportunity Controller****");
		int val = 0;
		val = auditDao.addAudit(audit);
		return val;
	}
	
}
