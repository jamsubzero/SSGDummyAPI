package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Student;

public interface StudentService {
		
	public abstract List<Student> insertStudents(List<Student> students);
	
	public abstract List<Student> getAllStudents();
	
	public abstract Optional<Student> getStudentById(int id);
	
	public abstract Student insertAStudent(Student student);
	
	public abstract void insertAStudentVoid(Student student);
	
}
