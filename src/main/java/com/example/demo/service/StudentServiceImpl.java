package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public List<Student> insertStudents(List<Student> students) {
	   return studentRepository.saveAll(students);	
	}
	
	@Override
	public Optional<Student>  getStudentById(int id) {
		return studentRepository.findById(id);  
	}

	@Override
	public Student insertAStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void insertAStudentVoid(Student student) {
		studentRepository.save(student);
	}

	

	

	
	
}






