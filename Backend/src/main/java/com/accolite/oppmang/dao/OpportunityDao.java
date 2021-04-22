package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.models.Opportunity;

public interface OpportunityDao {
	List <Opportunity> getAllOpportunities();
	
	Opportunity getOpportunity(int id);
	
	int addOpportunity(Opportunity opportunity);

    int deleteOpportunity(int id);

    int updateOpportunity(Opportunity opportunity, int id);
}
