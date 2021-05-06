package com.accolite.oppmang.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Audit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuditDaoTest {
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AuditDaoImpl auditDao;
	
	@Test
	public void ShouldgetAllAudit() throws DetailsNotFound {
		Assert.assertNotEquals(200, auditDao.getAllAudit().size());
	}
	
	@Test
	public void ShouldsearchAudits() throws DetailsNotFound {
		Assert.assertEquals(2, auditDao.searchAudits("oppId", "1").size());
		Assert.assertEquals(52, auditDao.searchAudits("email", "shahdhairya171099@gmail.com").size());
		Assert.assertEquals(1, auditDao.searchAudits("id", "7").size());
	}
	
	@Test
	public void ShouldaddAudit() throws DetailsNotFound
	{
		Audit audit1 = new Audit();
		audit1.setOppid(200);
		Assert.assertNotNull(audit1);
		Audit audit2 = new Audit("Dhairya", "test@gmail.com", "Create", "", "", 200);
		String res = audit2.toString();
		int res1 = auditDao.addAudit(audit2);
		Assert.assertEquals(audit1.getOppid(), audit2.getOppid());
	}
}
