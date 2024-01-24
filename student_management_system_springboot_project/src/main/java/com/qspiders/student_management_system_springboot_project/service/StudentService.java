package com.qspiders.student_management_system_springboot_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.qspiders.student_management_system_springboot_project.dao.StudentDao;
import com.qspiders.student_management_system_springboot_project.dto.Student;
import com.qspiders.student_management_system_springboot_project.exception.AddressNotFound;
import com.qspiders.student_management_system_springboot_project.exception.DataNotFound;
import com.qspiders.student_management_system_springboot_project.exception.EmailNotFound;
import com.qspiders.student_management_system_springboot_project.exception.GradeNotCorrect;
import com.qspiders.student_management_system_springboot_project.exception.IdNotFound;
import com.qspiders.student_management_system_springboot_project.exception.PhoneNotFound;
import com.qspiders.student_management_system_springboot_project.utility.ResponseStructure;

import jakarta.websocket.server.PathParam;

@Service
public class StudentService {

	double percent, percentage, per;
	@Autowired
	private StudentDao dao;

//**************************************************************************************
	public double calculatePercentage(int securedMarks, int totalMarks) {
		double total = (double) totalMarks;
		return percent = ((securedMarks / total) * 100);

	}

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		if (student.getSecuredMarks() <= student.getTotalMarks()) {
			percentage = calculatePercentage(student.getSecuredMarks(), student.getTotalMarks());
			per = ((int) (percentage * 100)) / 100.0;
			System.out.println(per);
			student.setStudPercentage(per);

			if ((percentage) > 80) {
				student.setGrade("Distinction");
			} else if (percentage > 65 && percentage <= 80) {
				student.setGrade("First Class");
			} else if (percentage > 55 && percentage <= 65) {
				student.setGrade("Second Class");
			} else if (percentage > 35 && percentage <= 55) {
				student.setGrade("Third Class");
			} else {
				student.setGrade("Fail");
			}
//			return dao.saveStudent(student);
		}
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Student Saved Successful");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(dao.saveStudent(student));
//		return dao.saveEmployee(employee);
//		return structure;
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> findStudent(int id) {
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		Student student = dao.findStudent(id);
		if (student != null) {
			structure.setMessage("Student Found Successful");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(student);
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Student Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(student);
//			return structure;
			throw new IdNotFound("Student with Given Id Not Found");
		}

//		return dao.findStudent(id);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.findAllStudent();
		if (list.isEmpty()) {
//			structure.setMessage("Not Data Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new DataNotFound("Data Not Found");
		} else {
			structure.setMessage("List Of Students Found");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND );
		}
//		return dao.findAllStudent();
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		Student student = dao.findStudent(id);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Student Deleted Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.deleteStudent(student));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Student Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
////			structure.setData(dao.deleteStudent(student));
//			return structure;
			throw new IdNotFound("Id Not Found To Delete Student");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {
		Student dbStudent = dao.findStudent(id);
		if (dbStudent != null) {
			if (student.getSecuredMarks() <= student.getTotalMarks()) {
				percentage = calculatePercentage(student.getSecuredMarks(), student.getTotalMarks());
				per = ((int) (percentage * 100)) / 100.0;
				student.setStudPercentage(per);
				if ((percentage) > 80) {
					student.setGrade("Distinction");
				} else if (percentage > 65 && percentage <= 80) {
					student.setGrade("First Class");
				} else if (percentage > 55 && percentage <= 65) {
					student.setGrade("Second Class");
				} else if (percentage > 35 && percentage <= 55) {
					student.setGrade("Third Class");
				} else {
					student.setGrade("Fail");
				}
			}
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Student updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			student.setId(id);
			structure.setData(dao.updateStudent(id, student));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Student Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(student);
//			return structure;
			throw new IdNotFound("Id Not Found To Update The Student");
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> saveAllStudent(List<Student> list) {
		
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		
		for (Student student : list) {
			if (student.getSecuredMarks() <= student.getTotalMarks()) {
				percentage = calculatePercentage(student.getSecuredMarks(), student.getTotalMarks());
				per = ((int) (percentage * 100)) / 100.0;
				student.setStudPercentage(per);

				if ((percentage) > 80) {
					student.setGrade("Distinction");
				} else if (percentage > 65 && percentage <= 80) {
					student.setGrade("First Class");
				} else if (percentage > 55 && percentage <= 65) {
					student.setGrade("Second Class");
				} else if (percentage > 35 && percentage <= 55) {
					student.setGrade("Third Class");
				} else {
					student.setGrade("Fail");
				}
			}
		}
//		return dao.saveAllStudent(list);

		structure.setMessage("All  Student saved Successful");
		structure.setStatus(HttpStatus.CREATED.value()); // structure.setStatus(201);
		structure.setData(dao.saveAllStudent(list));
//		return structure;
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) {
//		Student student = dao.findStudent(id);
//		if (student != null) {
//			student.setPhone(phone);
//			return dao.updatePhone(id, phone);
//		}
//		return null;
		
		Student student = dao.findStudent(id);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Employee Phone Updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.updatePhone(id, phone));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
			
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(dao.updatePhone(id, phone));
//			return structure;
			throw new PhoneNotFound("Phone Not Found To Update");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) {
		Student student = dao.findStudent(id);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Employee Email Updated Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.updateEmail(id, email));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Employee Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(dao.updateEmail(id, email));
//			return structure;
			throw new EmailNotFound("Email Not Found To Update");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findByPhone(long phone) {
		
		Student student = dao.findStudentByPhone(phone);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Student Found With Given Phone Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.findStudentByPhone(phone));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Student Not Found With Given Phone");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
////			structure.setData(employee);
//			return structure;
			throw new PhoneNotFound("Phone Not Found");
		}
		
//		return dao.findStudentByPhone(phone);
	}

	public ResponseEntity<ResponseStructure<Student>> findByEmail(String email) {
		Student student = dao.findStudentByEmail(email);
		if (student != null) {
			ResponseStructure<Student> structure = new ResponseStructure<Student>();
			structure.setMessage("Student Found With Given Email Successful");
			structure.setStatus(HttpStatus.OK.value()); // structure.setStatus(200);
			structure.setData(dao.findStudentByEmail(email));
//			return structure;
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		} else {
//			ResponseStructure<Student> structure = new ResponseStructure<Student>();
//			structure.setMessage("Student Not Found With Given Email");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
////			structure.setData(employee);
//			return structure;
			throw new EmailNotFound("Email Not Found");
		}
		
//		return dao.findStudentByEmail(email);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByAddress(String address) {
		
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.findStudentByAddress(address);
		
		if (list.isEmpty()) {
//			structure.setMessage("Student Not Found With Given Address");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new AddressNotFound("Address Not Found");
		} else {
			structure.setMessage("Students With Given Address Found ");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
		
//		return dao.findStudentByAddress(address);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByName(String name) {
		
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.findStudentByName(name);
		
		if (list.isEmpty()) {
//			structure.setMessage("Student Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new AddressNotFound("Name Not Found");
		} else {
			structure.setMessage("Student Found With Given Name");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
			
		}
		
//		return dao.findStudentByName(name);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByGrade(String grade) {
		
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.finStudentByGrade(grade);
		if (list.isEmpty()) {
//			structure.setMessage("Student Not Found");
//			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
//			structure.setData(list);
//			return structure;
			throw new GradeNotCorrect("Enter Correct Grade");
		} else {
			structure.setMessage("Students Found With Given grade");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> studMarkLessThan(int securedMarks) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.studMarkLessThan(securedMarks);
		if (list.isEmpty()) {
			structure.setMessage("Student Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Student Found With Less than Given Marks");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
////		return dao.empSalaryLessThan(salary);
	}

	public ResponseEntity<ResponseStructure<List<Student>>> studMarkGreaterThan(int securedMarks) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.studMarkGreaterThan(securedMarks);
		if (list.isEmpty()) {
			structure.setMessage("Student Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Student Found With Greater than Given Marks");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> markBetween(int securedMark1, int securedMark2) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> list = dao.studentBySecuredMarksBetween(securedMark1, securedMark2);
		if (list.isEmpty()) {
			structure.setMessage("Student Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value()); // structure.setStatus(404);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		} else {
			structure.setMessage("Student Found With Greater than Given Marks");
			structure.setStatus(HttpStatus.FOUND.value()); // structure.setStatus(302);
			structure.setData(list);
//			return structure;
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
	}

//	public List<Employee> empSalaryLessThan(double salary) {
//		return dao.empSalaryLessThan(salary);
//	}
//		
//	public List<Employee> salGreaterThan(double salary) {
//		return dao.salGreaterThan(salary);
//	}
//
//	public List<Employee> findByGrade(char grade){
//		return dao.findByGrade(grade);
//	}
//	
//	public List<Employee> findEmployeeBySalaryBetween(double salary1,double salary2){
//		return dao.findEmployeeBySalaryBetween(salary1,salary2);
//	}
//**********************************************************************************************
}
