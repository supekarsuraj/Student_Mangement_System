package com.qspiders.student_management_system_springboot_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspiders.student_management_system_springboot_project.dao.StudentDao;
import com.qspiders.student_management_system_springboot_project.dto.Student;
import com.qspiders.student_management_system_springboot_project.service.StudentService;
import com.qspiders.student_management_system_springboot_project.utility.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam int id) {
		return service.findStudent(id);
	}

	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return service.findAllStudent();
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		return service.deleteStudent(id);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@PostMapping("/saveall")
	public ResponseEntity<ResponseStructure<List<Student>>> saveAllStudent(@RequestBody List<Student> list){
		return service.saveAllStudent(list);
		
	}
	
	@PatchMapping("/updatephone")
	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id,long phone) {
		return service.updatePhone(id, phone);
	}
	
	@PatchMapping("/updateemail")
	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id,String email) {
		return service.updateEmail(id, email);
	}
	
	@GetMapping("/findbyphone")
	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) {
		return service.findByPhone(phone);
	}
	
	@GetMapping("/findbyemail")
	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) {
		return service.findByEmail(email);
	}
	
	@GetMapping("/findbyaddress")
	public ResponseEntity<ResponseStructure<List<Student>>> findByAddress(String address){
		return service.findByAddress(address);
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<ResponseStructure<List<Student>>> findByName(String name){
		return service.findByName(name);
	}
	
	@GetMapping("/findbygrade")
	public ResponseEntity<ResponseStructure<List<Student>>> findByGrade(String grade){
		return service.findByGrade(grade);
	}
	
	@GetMapping("/marklessthan")
	public ResponseEntity<ResponseStructure<List<Student>>> studMarkLessThan(int securedMarks){
		return service.studMarkLessThan(securedMarks);
	}
	
	@GetMapping("/markgreaterthan")
	public ResponseEntity<ResponseStructure<List<Student>>> studMarkGreaterThan(int securedMarks){
		return service.studMarkGreaterThan(securedMarks);
	}

	@GetMapping("/marksbetween")
	public ResponseEntity<ResponseStructure<List<Student>>> markBetween(int securedMark1,int securedMark2){
		return service.markBetween(securedMark1,securedMark2);
	}
//	//==================================================================
//	@PatchMapping("/updatemarks")
//	public Student updateMarks(int id,int securedMarks) {
//		return dao.updateMarks(id,securedMarks);
//	}
//	
//	@PatchMapping("/updateaddress")
//	public Student updateAddress(int id,String address) {
//		return dao.updateAddress(id,address);
//	}
//	
	
//	@GetMapping("/findbyemail")
//	public Student findByEmail(String email) {
//		return dao.findByEmail(email);
//	}
//	
//	@GetMapping("/findbyaddress")
//	public List<Student> findStudentByAddress(String address){
//		return dao.findByAddress(address);
//	}
//	
//	@GetMapping("/findbyname")
//	public List<Student> findEmplpyeeByName(String name){
//		return dao.findByName(name);
//	}
	//============================================================================
	
}
