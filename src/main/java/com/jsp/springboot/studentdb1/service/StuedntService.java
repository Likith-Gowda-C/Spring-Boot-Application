package com.jsp.springboot.studentdb1.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jsp.springboot.studentdb1.entity.Student;

public interface StuedntService {
	
	public Student  CreateStudent(Student student);
	
	public List<Student> findAllStudent();
	
	public boolean deleteStudentById(int studentId);
	
	public Student updateStudentById(Student student,int studentID);
	
	public Page<Student> getStudentById(int studentId,int page,int size);
}
