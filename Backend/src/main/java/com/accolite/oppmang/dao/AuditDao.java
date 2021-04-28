package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.models.Audit;

public interface AuditDao {
	List <Audit> getAllAudit();
	
	List <Audit> getAuditsById(int id);
	
	int addAudit(Audit audit);
}
