package com.example.demo.service;

import com.example.demo.entity.POJO.VoteRequest;
import com.example.demo.entity.POJO.VoteResponse;

public interface VoteRequestService {

	VoteResponse requestVote(VoteRequest voteRequest);
	
}
