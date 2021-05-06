package com.accolite.oppmang.dao;

import java.util.List;

import com.accolite.oppmang.models.Trend;

public interface TrendDao {
	Trend locationTrends();
	Trend skillTrends();
	Trend quarterTrends();
	Trend locationSkillsTrends();
	List < List<?> > locationCount();
	List < List<?> > skillCount();
	public int getLocationCount();
	public int getSkillCount();
	public int getYearCount();

}
