package com.qspiders.student_management_system_springboot_project.exception;

public class NameNotFound extends RuntimeException{

private String message;
	
	public NameNotFound(String message) {
		this.message = message ;
	}
	
	public String getMessage()
	{
		return message;
	}
}
