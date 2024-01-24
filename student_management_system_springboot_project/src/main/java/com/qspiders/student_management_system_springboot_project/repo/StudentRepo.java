package com.qspiders.student_management_system_springboot_project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qspiders.student_management_system_springboot_project.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Spring Boot Bacause Two Keywords "get" & "By"
	
//	Student findStudentByPhone(long phone);

	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Spring Boot Bacause Two Keywords "get" & "By"
	
	//Student getStudentByEmail(String email);

	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Us Using Query
	
	/*@Query("SELECT s FROM Student s WHERE s.address=?1")
	List<Student> studentByAddress(String address);*/

		
	//Cutomize Method to Find Employee By Phone
	//Implementation Given By Us Using Query
	/*@Query("SELECT s FROM Student s WHERE s.name=?1")
	List<Student> employeeByName(String name);*/

	Student findStudentById(int id);

	Student deleteStudentById(Student student);

	Student findStudentByPhone(long phone);

	Student getStudentByEmail(String email);

	List<Student> getStudentByAddress(String address);

	List<Student> getStudentByName(String name);

	List<Student> getStudentByGrade(String grade);

	List<Student> findStudentBySecuredMarksLessThan(int securedMarks);

	List<Student> findStudentBySecuredMarksGreaterThan(int securedMarks);

	List<Student> findStudentBySecuredMarksBetween(int securedMark1, int securedMark2);

//	Student deleteStudent(int id);
}
