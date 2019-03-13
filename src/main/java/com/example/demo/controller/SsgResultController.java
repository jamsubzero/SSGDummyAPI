package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SsgResult;
import com.example.demo.service.SsgResultServiceImpl;

@RestController
@RequestMapping("/ssgdummyapi")
public class SsgResultController {

	@Autowired
    SsgResultServiceImpl ssgResultServiceImpl;  
	
	@CrossOrigin("*")
	@GetMapping("/getresult/{pos}")
	public List<SsgResult> getResultByPos(@PathVariable("pos") String position){
		return ssgResultServiceImpl.getSsgResultByPos(position);
	}
	
	@CrossOrigin("*")
	@GetMapping("/getresult/All")
	public List<SsgResult> getAllResult(){
		return ssgResultServiceImpl.getAllSsgResult();
	}
	
	
	
	
}
