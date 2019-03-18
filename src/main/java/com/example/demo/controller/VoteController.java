package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SsgResult;
import com.example.demo.entity.model.Ballot;
import com.example.demo.entity.model.CastBallotResult;
import com.example.demo.entity.model.VoteRequest;
import com.example.demo.entity.model.VoteResponse;
import com.example.demo.service.SsgResultService;
import com.example.demo.service.VoteRequestService;
import com.example.demo.service.VoterService;

@RestController
@RequestMapping("/vote")
@CrossOrigin("*")
public class VoteController {
	
	@Autowired
	VoteRequestService voteRequestServiceImpl;
	
	@Autowired
	SsgResultService ssgResultServiceImpl;  
	
	@Autowired
	VoterService voterServiceImpl;

	@PostMapping("/voterequest")
	public VoteResponse requestVote(@RequestBody VoteRequest voteRequest) {
		return voteRequestServiceImpl.requestVote(voteRequest);	
	}
	
	
	//TODO add error handling for empty candidates i.e. if the voter did'nt voter
	@PostMapping("castballot")
	public CastBallotResult castBallot(@RequestBody Ballot ballot) {
		List<SsgResult> ssgResults = new ArrayList<>();
	    String voterID = ballot.getVoter();
	    voterServiceImpl.updateVoterStatus(voterServiceImpl.getVoterById(voterID).get());
	   
	    int presID = ballot.getPres(); 
	    ssgResults.add(ssgResultServiceImpl.addScore(ssgResultServiceImpl.getSsgById(presID).get()));
	    int vpID = ballot.getVp();
	    ssgResults.add(ssgResultServiceImpl.addScore(ssgResultServiceImpl.getSsgById(vpID).get()));
	    List<Integer> sen = ballot.getSen();
	    for(int senID: sen) {
	    	ssgResults.add(ssgResultServiceImpl.addScore(ssgResultServiceImpl.getSsgById(senID).get()));
	    }
	    List<Integer> rep = ballot.getRep();
	    for(int repID: rep) {
	    	ssgResults.add(ssgResultServiceImpl.addScore(ssgResultServiceImpl.getSsgById(repID).get()));
	    }
	    
	    ssgResultServiceImpl.insertResults(ssgResults);
		return new CastBallotResult("Success");
	}
	
	
	
	@GetMapping("tryCastballot")
	public Ballot tryCastBallot() {
		Ballot bal =  new Ballot("120927", 3, 1, 
				                    Arrays.asList(5, 6, 7),
				                    Arrays.asList(15, 16)
	  			                 );
		return bal;
	}
	
	
	
	
}
