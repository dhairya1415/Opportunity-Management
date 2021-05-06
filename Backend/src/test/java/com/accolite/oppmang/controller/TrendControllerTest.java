package com.accolite.oppmang.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.oppmang.controllers.TrendController;
import com.accolite.oppmang.dao.TrendDaoImpl;
import com.accolite.oppmang.models.Trend;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {TrendController.class})
public class TrendControllerTest {
	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public TrendDaoImpl trendDao;
	
	@Test
	public void ShouldgetLocationTrends() throws Exception
	{
		Mockito.when(trendDao.locationTrends()).thenReturn(new Trend());
		mockMvc.perform(get("/trends/locationTrends")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetQuarterTrends() throws Exception
	{
		Mockito.when(trendDao.quarterTrends()).thenReturn(new Trend());
		mockMvc.perform(get("/trends/quarterTrends")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetSkillTrends() throws Exception
	{
		Mockito.when(trendDao.skillTrends()).thenReturn(new Trend());
		mockMvc.perform(get("/trends/skillTrends")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetlocationSkillsTrends() throws Exception
	{
		Mockito.when(trendDao.locationSkillsTrends()).thenReturn(new Trend());
		mockMvc.perform(get("/trends/locationSkills")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetLocationCount() throws Exception
	{
		List < List <?> > list = new ArrayList<>();
		Mockito.when(trendDao.locationCount()).thenReturn(list);
		mockMvc.perform(get("/trends/locationCount")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetSkillCount() throws Exception
	{
		List < List <?> > list = new ArrayList<>();
		Mockito.when(trendDao.skillCount()).thenReturn(list);
		mockMvc.perform(get("/trends/skillCount")).andExpect(status().isOk());
	}
}
