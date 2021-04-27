package com.accolite.oppmang.exception;

public class DetailsNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Details Not Found";
	}
}
