package com.qspiders.student_management_system_springboot_project.exception;

public class GradeNotCorrect  extends RuntimeException{

	private String message;
	
	public GradeNotCorrect(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
