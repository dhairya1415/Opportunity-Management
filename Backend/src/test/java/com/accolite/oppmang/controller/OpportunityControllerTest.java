package com.accolite.oppmang.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.oppmang.controllers.OpportunityController;
import com.accolite.oppmang.dao.AuditDaoImpl;
import com.accolite.oppmang.dao.OpportunityDaoImpl;
import com.accolite.oppmang.models.Audit;
import com.accolite.oppmang.models.Opportunity;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {OpportunityController.class})
public class OpportunityControllerTest {
	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public OpportunityDaoImpl opportunityDao;
	
	@MockBean
	public AuditDaoImpl auditDaoImp;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	LocalDate date = LocalDate.now();
	Opportunity opportunity = new Opportunity("Dhairya","dhairya.shah@gmail.com","Frontend Engineer","Mumbai","React",2,4,date);
	

	@Test
	public void ShouldgetAllOpportunities() throws Exception
	{
		Mockito.when(opportunityDao.getAllOpportunities()).thenReturn(new ArrayList<Opportunity>());
		mockMvc.perform(get("/opportunity/getAll")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetActiveOpportunities() throws Exception
	{
		Mockito.when(opportunityDao.getActiveOpportunities()).thenReturn(new ArrayList<Opportunity>());
		mockMvc.perform(get("/opportunity/getActive")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldSearchOpportunities() throws Exception
	{
		Mockito.when(opportunityDao.searchOpportunities("Mumbai1")).thenReturn(new ArrayList<Opportunity>());
		mockMvc.perform(get("/opportunity/search/Mumbai1")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetLocations() throws Exception
	{
		Mockito.when(opportunityDao.getLocations()).thenReturn(new ArrayList<String>());
		mockMvc.perform(get("/opportunity/getLocations")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetSkills() throws Exception
	{
		Mockito.when(opportunityDao.getSkills()).thenReturn(new ArrayList<String>());
		mockMvc.perform(get("/opportunity/getSkills")).andExpect(status().isOk());
	}
	
	
	@Test
	public void ShouldgetOpportunity() throws Exception
	{
		Mockito.when(opportunityDao.getOpportunity(1)).thenReturn(new Opportunity());
		mockMvc.perform(get("/opportunity/get/1")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldgetLastOpportunity() throws Exception
	{
		Mockito.when(opportunityDao.getLastOpportunity()).thenReturn(new Opportunity());
		mockMvc.perform(get("/opportunity/getlast")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldaddOpportunity() throws Exception
	{
		String json = objectMapper.writeValueAsString(opportunity);
		Mockito.when(auditDaoImp.addAudit(new Audit("Dhairya Shah", "shahdhairya171099@gmail.com", "Create", "", "updated", 3))).thenReturn(1);
		Mockito.when(opportunityDao.addOpportunity(opportunity)).thenReturn(1);
		mockMvc.perform(post("/opportunity/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(json).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldupdateOpportunity() throws Exception
	{
		String json = objectMapper.writeValueAsString(opportunity);
		Mockito.when(auditDaoImp.addAudit(new Audit("Dhairya Shah", "shahdhairya171099@gmail.com", "Create", "", "updated", 3))).thenReturn(1);
		Mockito.when(opportunityDao.updateOpportunity(opportunity, 26)).thenReturn(1);
		mockMvc.perform(put("/opportunity/update/26").contentType(MediaType.APPLICATION_JSON_VALUE).content(json).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
	
	@Test
	public void ShoulddeleteOpportunity() throws Exception
	{
		Mockito.when(opportunityDao.deleteOpportunity(226)).thenReturn(0);
		Mockito.when(auditDaoImp.addAudit(new Audit("Dhairya Shah", "shahdhairya171099@gmail.com", "Create", "", "updated", 3))).thenReturn(1);
		mockMvc.perform(delete("/opportunity/delete/2")).andExpect(status().isOk());
	}
}
