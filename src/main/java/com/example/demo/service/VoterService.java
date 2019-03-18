package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Voter;

public interface VoterService {

	Voter updateVoterStatus(Voter voter);
	Optional<Voter> getVoterById(String id);
	
}
