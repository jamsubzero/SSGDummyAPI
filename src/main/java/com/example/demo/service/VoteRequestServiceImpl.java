package com.example.demo.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Voter;
import com.example.demo.entity.model.VoteRequest;
import com.example.demo.entity.model.VoteResponse;
import com.example.demo.repository.VoterRepository;


@Service
public class VoteRequestServiceImpl implements VoteRequestService {

	public static final Logger LOGGER = Logger.getLogger(VoteRequestService.class.getName());
	
	private final int STUDENT_EXISTS = 1;
	private final int STUDENT_NOT_EXISTS = 0;
	
	
	@Autowired
	VoterRepository voterRepository;

	@Override
	public VoteResponse requestVote(VoteRequest voteRequest) {
		LOGGER.info("VOTEREQUESTID:"+voteRequest.getId());
	  Optional<Voter> res = voterRepository.findVoterByIdAndOtp(voteRequest.getId(), voteRequest.getOtp());
	  
		if (!res.isPresent()) {
			return new VoteResponse("-", "-", "-", -1, STUDENT_NOT_EXISTS);
		}
		Voter voter = res.get();
		return new VoteResponse(voter.getId(), voter.getName(), voter.getCourse(), voter.getVoted(), STUDENT_EXISTS);

	}

}
