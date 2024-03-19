package com.carefirst.carefirstapp.exception;



public class EmployeeNotFound extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message ="Order not found";

	public EmployeeNotFound(String message) {
		super(message);
		 
	}
	
	

}
