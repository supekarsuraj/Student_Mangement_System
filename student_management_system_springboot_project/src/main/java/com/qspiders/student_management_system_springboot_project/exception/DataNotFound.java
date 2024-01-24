package com.qspiders.student_management_system_springboot_project.exception;

public class DataNotFound extends RuntimeException{

	private String message;

	public DataNotFound(String messsage) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
