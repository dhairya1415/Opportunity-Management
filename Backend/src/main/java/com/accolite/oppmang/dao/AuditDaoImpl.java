package com.accolite.oppmang.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Audit;
import com.accolite.oppmang.rowmapper.AuditRowMapper;

@Component
public class AuditDaoImpl {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List <Audit> getAllAudit() throws DetailsNotFound{
		List <Audit> auditList = new ArrayList<>();
		try {
			String query = "select * from audit";
			auditList = jdbcTemplate.query(query, new AuditRowMapper());
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return auditList;
	}
	
	public List <Audit> getAuditsById(int id) throws DetailsNotFound{
		List <Audit> auditList = new ArrayList<>();
		try {
			String query = "select * from audit where oppid="+id;
			auditList = jdbcTemplate.query(query, new AuditRowMapper());
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return auditList;
	}
	
	public int addAudit(Audit audit) {
		String query = "insert into audit (user_name, user_email, timestamp, action, initial, updated, oppid) values (?, ?, ?, ?, ?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(query, new Object[] {audit.getUser_name(), audit.getUser_email(), audit.getTimestamp(), audit.getAction(), audit.getInitial(), audit.getUpdated(), audit.getOppid()});
		return rowsAffected;
	}
}
