package com.jsp.springboot.studentdatabase.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.studentdatabase.entity.Student;
import com.jsp.springboot.studentdatabase.service.StudentServiceImpl;
import com.jsp.springboot.studentdatabase.utility.ResponseStructure;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private StudentServiceImpl studentServiceImpl;

	public StudentController(StudentServiceImpl studentServiceImpl) {
		super();
		this.studentServiceImpl = studentServiceImpl;
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentServiceImpl.createStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Student>>>
	findAllStudent(){
		List<Student> student=studentServiceImpl.findAllStudent();
		
		ResponseStructure<List<Student>> res=new ResponseStructure<List<Student>>();
		res.setStatusCode(HttpStatus.FOUND.value());;
		res.setMessage("Student Record Fetched Successfully!!");
		res.setData(student);
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(res,HttpStatus.FOUND);
	}
	
	@GetMapping("/by-id")
	public ResponseEntity<ResponseStructure<Page<Student>>>
	findByStudentId(@RequestParam int studentId,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size){
		Page<Student> stu=studentServiceImpl.findByStudentId(studentId, page, size);
		
		ResponseStructure<Page<Student>> res=new ResponseStructure<Page<Student>>();
		res.setStatusCode(HttpStatus.FOUND.value());
		res.setMessage("Student Record Fetched Successfully Based on the given student ID!!");
		res.setData(stu);
		
		return new ResponseEntity<ResponseStructure<Page<Student>>>(res,HttpStatus.FOUND);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>>
	updateByStudentId(@PathVariable("id") int studentId,@RequestBody Student student){
		
		Student updatedStudent=studentServiceImpl.updateByStudentId(studentId, student);
		
		ResponseStructure<Student> res=new ResponseStructure<Student>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Student Record Updated Successfully Based on Student ID!");
		res.setData(updatedStudent);
		
		return new ResponseEntity<ResponseStructure<Student>>(res,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>>
	deleteByStudentId(@PathVariable("id") int studentId){
		Student deleteStudent=studentServiceImpl.deleteByStudentId(studentId);
		
		ResponseStructure<Student> res=new ResponseStructure<Student>();
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Student Record Deleted Successfully Based on the given Stduent ID!");
		res.setData(deleteStudent);
		
		return new ResponseEntity<ResponseStructure<Student>>(res,HttpStatus.OK);
	}
}
