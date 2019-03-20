package com.example.demo.service;

import com.example.demo.entity.model.VoteRequest;
import com.example.demo.entity.model.VoteResponse;

public interface VoteRequestService {

	VoteResponse requestVote(VoteRequest voteRequest);
	
	
	
}
