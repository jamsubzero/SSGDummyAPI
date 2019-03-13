package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectServiceImpl;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	SubjectServiceImpl  subjectServiceImpl;
	
	@PostMapping("/insert")
	public Subject insertSubject(@RequestBody Subject subject) {
		return subjectServiceImpl.insertStudent(subject);
	}
	
	

}
