package com.accolite.oppmang.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(path="get/{id}")
	public List <Audit> getAuditsById(@PathVariable("id") int id){
		logger.info("****getAuditsById method Audit Contoller****");
		List <Audit> auditList = null;
		try {
			auditList = auditDao.getAuditsById(id);
		} catch (DetailsNotFound e) {
			// TODO Auto-generated catch block
			logger.error("****DetailsNotFound Audit Controller****");
		}
		return auditList;
	}
	
}
