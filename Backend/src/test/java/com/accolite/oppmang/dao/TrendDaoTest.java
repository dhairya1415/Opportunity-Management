package com.accolite.oppmang.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.oppmang.models.Trend;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrendDaoTest {
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TrendDaoImpl trendDao;
	
	@Test
	public void ShouldgetYearCount() {
		Assert.assertEquals(3, trendDao.getYearCount());
	}
	
	@Test
	public void ShouldgetLocationCount() {
		Assert.assertEquals(3, trendDao.getLocationCount());
	}
	
	@Test
	public void ShouldgetSkillCount() {
		Assert.assertEquals(6, trendDao.getSkillCount());
	}
	
	@Test
	public void ShouldgetLocationTrends() {
		Trend trend = trendDao.locationTrends();
		Assert.assertNotNull(trend);
		Assert.assertEquals(3, trend.getColumns().size());
	}
	
	@Test
	public void ShouldgetQuarterTrends() {
		Trend trend = trendDao.quarterTrends();
		Assert.assertNotNull(trend);
		Assert.assertEquals(4, trend.getColumns().size());
	}
	
	@Test
	public void ShouldgetSkillTrends() {
		Trend trend = trendDao.skillTrends();
		Assert.assertNotNull(trend);
		Assert.assertEquals(6, trend.getColumns().size());
	}
	
	@Test
	public void ShouldgetlocationSkillsTrends() {
		Trend trend = trendDao.locationSkillsTrends();
		Assert.assertNotNull(trend);
		Assert.assertEquals(2, trend.getColumns().size());
	}
	
	@Test
	public void ShouldgetskillCount() {
		List < List <?> > trend = trendDao.skillCount();
		Assert.assertNotNull(trend);
		Assert.assertEquals(2, trend.size());
	}
	
	@Test
	public void ShouldgetlocationCount() {
		List < List <?> > trend = trendDao.locationCount();
		Assert.assertNotNull(trend);
		Assert.assertEquals(2, trend.size());
	}
}
