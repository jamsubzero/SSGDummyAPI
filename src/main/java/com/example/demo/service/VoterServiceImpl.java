package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Voter;
import com.example.demo.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService{

	private final int VOTED_STATUS = 1;
	
	@Autowired
	VoterRepository voterRepository;
	
	@Override
	public Voter updateVoterStatus(Voter voter) {
		voter.setVoted( VOTED_STATUS );
		voterRepository.save(voter);
		return voter;
	}

	@Override
	public Optional<Voter> getVoterById(String id) {
		return voterRepository.findById(id);
	}

	
	
}
