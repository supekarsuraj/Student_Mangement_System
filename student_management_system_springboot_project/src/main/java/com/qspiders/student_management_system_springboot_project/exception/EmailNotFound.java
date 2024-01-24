package com.qspiders.student_management_system_springboot_project.exception;

public class EmailNotFound extends RuntimeException{

private String message;
	
	public EmailNotFound(String message) {
		this.message = message ;
	}
	
	public String getMessage()
	{
		return message;
	}
}
