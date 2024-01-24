package com.qspiders.student_management_system_springboot_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.qspiders.student_management_system_springboot_project.dto.Student;
import com.qspiders.student_management_system_springboot_project.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public Student findStudent(int id) {
		return repo.findStudentById(id);
	}

	public List<Student> findAllStudent() {
		return repo.findAll();
	}

	public Student deleteStudent(Student Student) {
		repo.delete(Student);
		return Student;
	}

	public Student updateStudent(int id, Student student) {
		return repo.save(student);
	}

	public List<Student> saveAllStudent(@RequestBody List<Student> list) {
		return repo.saveAll(list);
	}

	public Student updatePhone(int id, long phone) {
		Optional optional = repo.findById(id);
		if (optional.isPresent()) {
			Student student = (Student) optional.get();
			student.setPhone(phone);
			return repo.save(student);
		}
		return null;
	}

	public Student updateEmail(int id, String email) {
		Optional optional = repo.findById(id);
		if (optional.isPresent()) {
			Student student = (Student) optional.get();
			student.setEmail(email);
			return repo.save(student);
		}
		return null;
	}

	public Student findStudentByPhone(long phone) {
		return repo.findStudentByPhone(phone);
	}

	public Student findStudentByEmail(String email) {
		return repo.getStudentByEmail(email);
	}

	public List<Student> findStudentByAddress(String address) {
		return repo.getStudentByAddress(address);
	}

	public List<Student> findStudentByName(String name) {
		return repo.getStudentByName(name);
	}

	public List<Student> finStudentByGrade(String grade) {
		return repo.getStudentByGrade(grade);
	}


	public List<Student> studMarkLessThan(int securedMarks) {
		return repo.findStudentBySecuredMarksLessThan(securedMarks);
	}
	
	public List<Student> studMarkGreaterThan(int securedMarks) {
		return repo.findStudentBySecuredMarksGreaterThan(securedMarks);
	}

	public List<Student> studentBySecuredMarksBetween(int securedMark1, int securedMark2) {
		return repo.findStudentBySecuredMarksBetween(securedMark1,securedMark2);
	}



	
	/*
	 * public Student deleteStudent(int id) { Optional<Student> optional =
	 * repo.findById(id); if (optional.isPresent()) { // repo.deleteById(id); //
	 * return optional.get();
	 * 
	 * Student student = optional.get(); repo.delete(student); return student; }
	 * return null;
	 * 
	 * // ===============Optinal code for above===================== /*
	 * if(optional.isEmpty()) { return null; } return optional.get();
	 */
	// =========================================================
//		}

	/*
	 * public Student updateStudent(int id,Student student) { Optional<Student>
	 * optional = repo.findById(id); if (optional.isPresent()) { // Student student
	 * = optional.get(); student.setId(id); return repo.save(student); } return
	 * null; }
	 */

	/*
	 * public List<Student> saveAllStudent(@RequestBody List<Student> list){ return
	 * repo.saveAll(list); }
	 * 
	 * public Student updatePhone(int id, long phone) {
	 * 
	 * Optional optional = repo.findById(id); if(optional.isPresent()) { Student
	 * student = (Student) optional.get(); student.setPhone(phone); return
	 * repo.save(student); } return null; }
	 * 
	 * public Student updateEmail(int id, String email) { Optional optional =
	 * repo.findById(id); if(optional.isPresent()) { Student student = (Student)
	 * optional.get(); student.setEmail(email); return repo.save(student); } return
	 * null; }
	 * //======================================================================
	 * public Student updateMarks(int id,int securedMarks) { Optional optional =
	 * repo.findById(id); if(optional.isPresent()) { Student student = (Student)
	 * optional.get(); student.setSecuredMarks(securedMarks); return
	 * repo.save(student); } return null; }
	 * 
	 * public Student updateAddress(int id,String address) { Optional optional =
	 * repo.findById(id); if(optional.isPresent()) { Student student = (Student)
	 * optional.get(); student.setAddress(address); return repo.save(student); }
	 * return null; }
	 * 
	 * public Student findByPhone(long phone) { return
	 * repo.findStudentByPhone(phone); }
	 * 
	 * public Student findByEmail(String email) { return
	 * repo.getStudentByEmail(email); }
	 * 
	 * public List<Student> findByAddress(String address) { return
	 * repo.studentByAddress(address); }
	 * 
	 * public List<Student> findByName(String name) { return
	 * repo.employeeByName(name); }
	 */
//=========================================================================

}