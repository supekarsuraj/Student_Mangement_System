package com.qspiders.student_management_system_springboot_project.exception;

public class IdNotFound extends RuntimeException {
	
	private String message;
	
	public IdNotFound(String messsage) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
