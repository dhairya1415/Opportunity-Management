package com.accolite.oppmang.models;

import java.util.List;

public class Trend {
	private List <String> years;
	private List <String> columns;
	private long data[][];

	public List <String> getYears() {
		return years;
	}

	public void setYears(List <String> years) {
		this.years = years;
	}

	public List <String> getColumns() {
		return columns;
	}

	public void setColumns(List <String> columns) {
		this.columns = columns;
	}

	public long[][] getData() {
		return data;
	}

	public void setData(long data[][]) {
		this.data = data;
	}
	
	
}
