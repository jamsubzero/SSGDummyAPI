package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("/enrolment")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/insert")
	public List<Student> insertStudents(@RequestBody List<Student> students) {
		return studentServiceImpl.insertStudents(students);
	}
	
	@PostMapping("/insertone")
	public Student insertStudent(@RequestBody Student student) {
		return studentServiceImpl.insertAStudent(student);
	}

	@PostMapping("/insertonevoid")
	public String insertStudentVoid(@RequestBody Student student) {
		studentServiceImpl.insertAStudent(student);
		return "new Student inserted: " + student.getName();
	}
	
	@GetMapping("/getallstd")
	public List<Student> getStudents(){
		return studentServiceImpl.getAllStudents();
	}
	
	@GetMapping("/hi")
	public String sayHi(){
		return "hi";
	}
	
	
	@GetMapping("/getstd")
	public Student getStudent(@RequestParam("id") int id){
		return studentServiceImpl.getStudentById(id).get();
	}
	
	@GetMapping("/getstd/{id}")
	public Student getAStudent(@PathVariable("id") int id){
		return studentServiceImpl.getStudentById(id).get();
	}
	
}
