package com.accolite.oppmang.dao;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Opportunity;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityDaoTest {
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	OpportunityDaoImpl opportunityDao;
	
	@Autowired
	AuditDaoImpl auditDao;
	
	@Test
	public void ShouldgetAllOpportunities() throws DetailsNotFound {
		Assert.assertNotEquals(35, opportunityDao.getAllOpportunities().size());
	}
	
	@Test
	public void ShouldgetActiveOpportunities() throws DetailsNotFound {
		Assert.assertNotEquals(100, opportunityDao.getActiveOpportunities().size());
	}
	
	@Test
	public void ShouldgetLocations() throws DetailsNotFound {
		Assert.assertEquals(3, opportunityDao.getLocations().size());
	}
	
	@Test
	public void ShouldgetSkills() throws DetailsNotFound {
		Assert.assertEquals(6, opportunityDao.getSkills().size());
	}
	
	@Test
	public void ShouldgetOpportunity() throws DetailsNotFound
	{
		Opportunity opportunity = new Opportunity();
		opportunity.setOppid(2);
		Assert.assertEquals(opportunity.getOppid(), opportunityDao.getOpportunity(2).getOppid());
	}
	
	@Test
	public void ShouldgetLastOpportunity() throws DetailsNotFound
	{
		Opportunity opportunity = new Opportunity();
		opportunity.setOppid(35);
		Assert.assertNotEquals(opportunity.getOppid(), opportunityDao.getLastOpportunity().getOppid());
	}
	
	@Test
	public void ShouldsearchOpportunities() throws DetailsNotFound{
		Assert.assertNotEquals(0, opportunityDao.searchOpportunities("Mumbai1").size());
		Assert.assertNotEquals(100, opportunityDao.searchOpportunities("1React").size());
		Assert.assertNotEquals(100, opportunityDao.searchOpportunities("Mumbai1React").size());
	}
	
	@Test
	public void ShouldaddOpportunity() throws DetailsNotFound
	{
		int res1 = 1;
		LocalDate date = LocalDate.now();
		int res2 = opportunityDao.addOpportunity(new Opportunity("Dhairya","dhairya.shah@gmail.com","Frontend Engineer","Mumbai","React",2,4,date));
		String res = new Opportunity("Dhairya","dhairya.shah@gmail.com","Frontend Engineer","Mumbai","React",2,4,date).toString();
		Assert.assertEquals(res1, res2);
		
	}
	
	@Test
	public void ShouldupdateOpportunity() throws DetailsNotFound
	{
		int res1 = 0;
		LocalDate date = LocalDate.now();
		int res2 = opportunityDao.updateOpportunity(new Opportunity("Dhairya","dhairya.shah@gmail.com","Frontend Engineer","Mumbai","React",2,4,date), 101);
		Assert.assertEquals(res1,res2);
		
	}
	
	@Test
	public void ShoulddeleteOpportunity() throws DetailsNotFound
	{
		int res1 = 0;
		int res2 = opportunityDao.deleteOpportunity(100);
		Assert.assertEquals(res1,res2);
		
	}
}
