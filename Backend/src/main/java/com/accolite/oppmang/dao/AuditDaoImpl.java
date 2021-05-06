package com.accolite.oppmang.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Audit;
import com.accolite.oppmang.rowmapper.AuditRowMapper;

@Repository("AuditDao")
@Transactional
public class AuditDaoImpl implements AuditDao{
	
	public AuditDaoImpl() {}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List <Audit> getAllAudit() throws DetailsNotFound{
		List <Audit> auditList = new ArrayList<>();
		try {
			String query = "select * from audit order by audid desc";
			auditList = jdbcTemplate.query(query, new AuditRowMapper());
		} catch (Exception e) {
			throw (DetailsNotFound)e;
		}
		return auditList;
	}
	
	@Override
	public List <Audit> searchAudits(String key, String value) throws DetailsNotFound{
		List <Audit> auditList = new ArrayList<>();
		String query = "";
		try {
			if(key.equals("email")) {
				query = "select * from audit where user_email like '%" +value+"%' order by audid desc;";
				System.out.println("Email working");
			} else if(key.equals("oppId")) {
				query = "select * from audit where oppId="+Integer.parseInt(value)+" order by audid desc";
				System.out.println("oppId working");
			}
			else {
				query = "select * from audit where audid="+Integer.parseInt(value);
				System.out.println("Id working");
			}
			auditList = jdbcTemplate.query(query, new AuditRowMapper());
		} catch (Exception e) {
			throw e;
		}
		return auditList;
	}
	
	@Override
	public int addAudit(Audit audit) {
		String query = "insert into audit (user_name, user_email, timestamp, action, initial, updated, oppid) values (?, ?, ?, ?, ?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(query, new Object[] {audit.getUser_name(), audit.getUser_email(), audit.getTimestamp(), audit.getAction(), audit.getInitial(), audit.getUpdated(), audit.getOppid()});
		return rowsAffected;
	}
}
