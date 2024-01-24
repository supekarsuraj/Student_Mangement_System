package com.qspiders.student_management_system_springboot_project.exception;

public class PhoneNotFound extends RuntimeException{

	private String message;
	
	public PhoneNotFound(String message) {
		this.message = message ;
	}
	
	public String getMessage()
	{
		return message;
	}
}
