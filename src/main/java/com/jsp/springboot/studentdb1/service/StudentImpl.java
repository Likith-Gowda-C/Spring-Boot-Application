package com.jsp.springboot.studentdb1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jsp.springboot.studentdb1.entity.Student;
import com.jsp.springboot.studentdb1.repository.StudentRepository;

@Service
public class StudentImpl implements StuedntService{
	
	private StudentRepository studentRepository;
	
	public StudentImpl(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	//CREATION OF STUDENT:
	@Override
	public Student CreateStudent(Student student) {
		return studentRepository.save(student);
	}

	//FETCHING ALL STUDENT:
	@Override
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}
	
	//FETCHING STUDENT DATA USING PAGINATION
	@Override
	public Page<Student> getStudentById(int studentId, int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return studentRepository.findByStudentId(studentId, pageable);
	}
	
	//UPDATING STUDENT USING STUDENTID:
//	@Override
//	public Student updateStudentById(Student student,int studentID) {
//		Optional<Student> existing=studentRepository.findById(studentID);
//		
//		if(existing.isPresent()) {
//			Student exstudent=existing.get();
//			exstudent.setStudentName(student.getStudentName());
//			exstudent.setStudentAge(student.getStudentAge());
//			exstudent.setStudentMarks(student.getStudentMarks());
//			return studentRepository.save(student);
//		} else {
//			return null;
//		}
//	}
	
	//UPDATING STUDENT USING STUDENTID USING @PATCH IN CONTROLLER:
	@Override
	public Student updateStudentById(Student student, int studentID) {
		Optional<Student> exist=studentRepository.findById(studentID);
		
		if(exist.isPresent()) {
			Student studentexist=exist.get();
			
			if(student.getStudentName() != null) {
				studentexist.setStudentName(student.getStudentName());
			}
			
			if(student.getStudentAge() != 0) {
				studentexist.setStudentAge(student.getStudentAge());
			}
			
			if(student.getStudentMarks() != 0) {
				studentexist.setStudentMarks(student.getStudentMarks());
			}
			
			return studentRepository.save(studentexist);
		}
		else {
			return null;
		}
	}
	
	//DELETEING STUDENT USING ID;
	@Override
	public boolean deleteStudentById(int studentId) {
		if(studentRepository.existsById(studentId)) {
			studentRepository.deleteById(studentId);
			return true;
		}
		return false;
	}

}
