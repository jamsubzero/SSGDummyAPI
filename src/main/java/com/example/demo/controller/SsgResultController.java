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
import com.example.demo.entity.model.CastBallotResult;
import com.example.demo.service.SsgResultService;
import com.example.demo.service.SsgResultServiceImpl;

@RestController
@RequestMapping("/ssgapi")
@CrossOrigin("*") // allow all client origins
public class SsgResultController {

	@Autowired
	SsgResultService ssgResultServiceImpl;  

	@GetMapping("/getresult/{pos}")
	public List<SsgResult> getResultByPos(@PathVariable("pos") String position){
		return ssgResultServiceImpl.getSsgResultByPos(position);
	}
	
	
	@GetMapping("/get/{pos}")
	public List<SsgResult> getSsgByPos(@PathVariable("pos") String position){
		return ssgResultServiceImpl.getSsgByPos(position);
	}
	 
	 
	@GetMapping("/getresult/all")
	public List<SsgResult> getAllResult(){
		return ssgResultServiceImpl.getAllSsgResult();
	}
	
	@PostMapping("/insertresults")
	public List<SsgResult> insertResults(@RequestBody List<SsgResult> results){
		return ssgResultServiceImpl.insertResults(results);
	}
	
	@PostMapping("/insertcanditate")
	public List<SsgResult> insertCandidate(@RequestBody SsgResult ssgResult){
		ssgResultServiceImpl.insertOrSaveSsgResult(ssgResult);
		return ssgResultServiceImpl.getAllSsgResult();
	}
	
	@GetMapping("/delete/{id}")
	public List<SsgResult> deleteCandidate(@PathVariable("id") int id){
		ssgResultServiceImpl.deleteSsgResultById(id);
		return ssgResultServiceImpl.getAllSsgResult();
	}
	
		
}