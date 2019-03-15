package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SsgResult;
import com.example.demo.service.SsgResultServiceImpl;

@RestController
@RequestMapping("/ssgdummyapi")
@CrossOrigin("*") // allow all client origins
public class SsgResultController {

	@Autowired
    SsgResultServiceImpl ssgResultServiceImpl;  

	@GetMapping("/getresult/{pos}")
	public List<SsgResult> getResultByPos(@PathVariable("pos") String position){
		return ssgResultServiceImpl.getSsgResultByPos(position);
	}
	
	@GetMapping("/getresult/All")
	public List<SsgResult> getAllResult(){
		return ssgResultServiceImpl.getAllSsgResult();
	}
	
	@PostMapping("/insertresults")
	public List<SsgResult> insertResults(@RequestBody List<SsgResult> results){
		return ssgResultServiceImpl.insertResults(results);
	}
	
	
}
