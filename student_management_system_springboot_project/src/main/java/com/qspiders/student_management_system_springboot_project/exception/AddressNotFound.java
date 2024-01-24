package com.qspiders.student_management_system_springboot_project.exception;

public class AddressNotFound extends RuntimeException{

private String message;
	
	public AddressNotFound(String message) {
		this.message = message ;
	}
	
	public String getMessage()
	{
		return message;
	}
}
