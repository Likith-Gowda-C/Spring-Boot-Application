package com.jsp.springboot.studentdatabase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jsp.springboot.studentdatabase.entity.Student;
import com.jsp.springboot.studentdatabase.exception.NoStudentFoundException;
import com.jsp.springboot.studentdatabase.exception.StudentNotFoundByIdException;
import com.jsp.springboot.studentdatabase.exception.UpdateByStudentIdException;
import com.jsp.springboot.studentdatabase.exception.deleteByStudentIdException;
import com.jsp.springboot.studentdatabase.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> stu=studentRepository.findAll();
		
		if(stu.isEmpty()) {
			throw new NoStudentFoundException("No Students Found");
		} else 
			return stu;
	}

	@Override
	public Page<Student> findByStudentId(int studentId,int page,int size) {
		
		Pageable pageable=PageRequest.of(page,size);
		Page<Student> stu=studentRepository.findByStudentId(studentId, pageable);
		
		if(stu.isEmpty()) {
			throw new StudentNotFoundByIdException("Student With Given Student Dosen't Exist");
		} else
			return stu;
	}

	@Override
	public Student updateByStudentId(int StudentId, Student student) {
		
		Optional<Student> stu=studentRepository.findById(StudentId);
		
		if(stu.isPresent()) {
			Student existing=stu.get();
			
			if(existing.getStudentName() != null) {
				existing.setStudentName(student.getStudentName());
			}
			
			if(existing.getStudentAge() != 0) {
				existing.setStudentAge(student.getStudentAge());
			}
			
			if(existing.getStudentMarks() != 0) {
				existing.setStudentMarks(student.getStudentMarks());
			}
			
			return studentRepository.save(existing);
		} else 
			throw new UpdateByStudentIdException("Student with Such Student ID Dosen't Exist!");
	}

	@Override
	public Student deleteByStudentId(int studentId) {
		Optional<Student> op=studentRepository.findById(studentId);
		
		if(op.isEmpty()) {
			throw new deleteByStudentIdException("Student With Such Student ID Dosen't Exist!");
		} else {
			Student student=op.get();
			studentRepository.deleteById(studentId);
			return student;
		}
	}
	
	
}
