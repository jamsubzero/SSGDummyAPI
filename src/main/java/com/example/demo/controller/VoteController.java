package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.POJO.VoteRequest;
import com.example.demo.entity.POJO.VoteResponse;
import com.example.demo.service.VoteRequestServiceImpl;

@RestController
@RequestMapping("/vote")
@CrossOrigin("*")
public class VoteController {
	
	@Autowired
	VoteRequestServiceImpl VoteRequestServiceImpl;

	@PostMapping("/voterequest")
	public VoteResponse requestVote(@RequestBody VoteRequest voteRequest) {
		return VoteRequestServiceImpl.requestVote(voteRequest);	
	}
	
	@GetMapping("/getreq")
	public VoteRequest getReq() {
		return new VoteRequest("HD00000000");
	}
	
}
