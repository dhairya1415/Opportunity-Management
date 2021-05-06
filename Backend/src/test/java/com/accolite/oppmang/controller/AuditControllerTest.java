package com.accolite.oppmang.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.oppmang.controllers.AuditController;
import com.accolite.oppmang.dao.AuditDaoImpl;
import com.accolite.oppmang.models.Audit;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {AuditController.class})
public class AuditControllerTest {
	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public AuditDaoImpl auditDao;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Audit audit = new Audit("Dhairya Shah", "shahdhairya171099@gmail.com", "Create", "", "updated", 3);
	
	@Test
	public void ShouldgetAllAudit() throws Exception {
		Mockito.when(auditDao.getAllAudit()).thenReturn(new ArrayList<Audit>());
		mockMvc.perform(get("/audit/getAll")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldSearchAudits() throws Exception
	{
		Mockito.when(auditDao.searchAudits("oppId", "9")).thenReturn(new ArrayList<Audit>());
		mockMvc.perform(get("/audit/search/oppId/9")).andExpect(status().isOk());
	}
	
	@Test
	public void ShouldaddAudit() throws Exception {
		String json = objectMapper.writeValueAsString(audit);
		Mockito.when(auditDao.addAudit(audit)).thenReturn(1);
		mockMvc.perform(post("/audit/add").contentType(MediaType.APPLICATION_JSON_VALUE).content(json).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}
}
