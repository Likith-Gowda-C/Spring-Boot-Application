package com.jsp.springboot.studentdb1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jsp.springboot.studentdb1.entity.Student;

public interface StudentRepository extends MongoRepository<Student,Integer>{
	
	Page<Student> findByStudentId(int studentId,Pageable pageable);
}
