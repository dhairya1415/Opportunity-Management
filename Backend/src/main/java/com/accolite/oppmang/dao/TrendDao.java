package com.accolite.oppmang.dao;

import com.accolite.oppmang.models.Trend;

public interface TrendDao {
	Trend locationTrends();
	Trend skillTrends();
	Trend quarterTrends();
	public int getLocationCount();
	public int getSkillCount();
	public int getYearCount();

}
