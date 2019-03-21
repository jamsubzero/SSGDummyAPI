package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Voter;
import com.example.demo.entity.model.GenOpResult;
import com.example.demo.entity.model.VotingStatistics;

public interface VoterService {

	Voter updateVoterStatus(Voter voter);
	Optional<Voter> getVoterById(String id);
	GenOpResult generateOTPById(String voter);
	int reZeroVoter(Integer status, String otp);
	VotingStatistics getStatisticsByCourse(String course);
	VotingStatistics getOverAllStatistics();
	
	
}
