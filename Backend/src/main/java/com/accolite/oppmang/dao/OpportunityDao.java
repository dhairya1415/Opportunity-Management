package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.exception.DetailsNotFound;
import com.accolite.oppmang.models.Opportunity;

public interface OpportunityDao {
	List <Opportunity> getAllOpportunities() throws DetailsNotFound;
	
	List <Opportunity> getActiveOpportunities() throws DetailsNotFound;
	
	List <Opportunity> searchOpportunities(String options) throws DetailsNotFound;
	
	List <String> getLocations() throws DetailsNotFound;
	
	List <String> getSkills() throws DetailsNotFound;
	
	Opportunity getOpportunity(int id) throws DetailsNotFound;
	
	Opportunity getLastOpportunity() throws DetailsNotFound;
	
	int addOpportunity(Opportunity opportunity);

    int deleteOpportunity(int id);

    int updateOpportunity(Opportunity opportunity, int id);
}
