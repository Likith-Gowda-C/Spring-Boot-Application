package com.jsp.springboot.studentdatabase.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jsp.springboot.studentdatabase.entity.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public Page<Student> findByStudentId(int studentId,int page,int size);
	
	public Student updateByStudentId(int StudentId,Student student);
	
	public Student deleteByStudentId(int studentId);
}
