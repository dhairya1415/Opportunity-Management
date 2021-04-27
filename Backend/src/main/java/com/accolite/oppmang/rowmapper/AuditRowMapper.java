package com.accolite.oppmang.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.oppmang.models.Audit;

public class AuditRowMapper implements RowMapper<Audit>{
	@Override
	public Audit mapRow(ResultSet rs, int rowNum) throws SQLException{
		Audit audit = new Audit();
		audit.setAudid(rs.getInt("audid"));
		audit.setUser_name(rs.getString("user_name"));
		audit.setUser_email(rs.getString("user_email"));
		audit.setTimestamp(rs.getString("timestamp"));
		audit.setAction(rs.getString("action"));
		audit.setInitial(rs.getString("initial"));
		audit.setUpdated(rs.getString("updated"));
		audit.setOppid(rs.getInt("oppid"));
		return audit;
	}
}

