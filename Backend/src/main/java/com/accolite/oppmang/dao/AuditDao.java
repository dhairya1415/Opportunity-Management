package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Audit;

public interface AuditDao {
	List <Audit> getAllAudit() throws DetailsNotFound;
	
	List <Audit> searchAudits(String key, String value) throws DetailsNotFound;
	
	int addAudit(Audit audit);
}
