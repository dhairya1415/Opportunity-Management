package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.models.Audit;

public interface AuditDao {
	List <Audit> getAllAudit();
	
	int addAudit(Audit audit);
}
