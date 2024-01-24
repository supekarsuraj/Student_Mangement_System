package com.qspiders.student_management_system_springboot_project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name can't be Blank")
	@NotNull(message = "Name Can't be Null")
	private String name;
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	@Column(unique = true)
	private long phone;
	
	@NotBlank(message = "Address can't be Blank")
	@NotNull(message = "Address Can't be Null")
	private String address;
	
	@NotBlank(message = "Email can't be Blank")
	@NotNull(message = "Email Can't be Null")
	@Column(unique = true)
	@Email(regexp = "[a-z 0-9  . _ $ ]+@[a-z]+\\.[a-z]{2,3}",message="Enter Proper Email")
	private String email;
	
	private int securedMarks;
	
	private int totalMarks;
	
	private String grade;
	
	private double studPercentage;
	
	public double getStudPercentage() {
		return studPercentage;
	}

	public void setStudPercentage(double percentage) {
		this.studPercentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getSecuredMarks() {
		return securedMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSecuredMarks(int securedMarks) {
		this.securedMarks = securedMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

}
