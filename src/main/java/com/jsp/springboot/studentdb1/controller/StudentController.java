package com.jsp.springboot.studentdb1.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.studentdb1.entity.Student;
import com.jsp.springboot.studentdb1.service.StudentImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentImpl studentImpl;

	public StudentController(StudentImpl studentImpl) {
		super();
		this.studentImpl = studentImpl;
	}
	
	@PostMapping
	public Student CreateStudent(@RequestBody Student student) {
		return studentImpl.CreateStudent(student);
	}
	
	@GetMapping
	public List<Student> findAllStudents(){
		return studentImpl.findAllStudent();
	}
	
	@GetMapping("/by-id")
	public Page<Student> getStudeneById(@RequestParam int studentId,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size){
		return studentImpl.getStudentById(studentId, page, size);
	}
	
//	@PutMapping("/{id}")
//	public Student updateStudetByID(@PathVariable("id") int studentId,@RequestBody Student student) {
//		return studentImpl.updateStudentById(student, studentId);
//	}
	
	@PatchMapping("/{id}")
	public Student updateStudetByID(@PathVariable("id") int studentId,@RequestBody Student student) {
		return studentImpl.updateStudentById(student, studentId);
	}
	
	@DeleteMapping
	public String deleteByStudentId(@RequestParam int studentId) {
		return studentImpl.deleteStudentById(studentId)
				? "Student Record Deleted":"Student Not Found";
	}
}
