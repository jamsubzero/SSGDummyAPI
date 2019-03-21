package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SsgResult;
import com.example.demo.entity.model.Ballot;
import com.example.demo.entity.model.CastBallotResult;
import com.example.demo.entity.model.GenOpResult;
import com.example.demo.entity.model.VoteRequest;
import com.example.demo.entity.model.VoteResponse;
import com.example.demo.entity.model.VotingStatistics;
import com.example.demo.service.SsgResultService;
import com.example.demo.service.VoteRequestService;
import com.example.demo.service.VoterService;

@RestController
@RequestMapping("/vote")
@CrossOrigin("*")
public class VoteController {

	private Logger logger = Logger.getLogger(VoteController.class.getName());

	@Autowired
	VoteRequestService voteRequestServiceImpl;

	@Autowired
	SsgResultService ssgResultServiceImpl;

	@Autowired
	VoterService voterServiceImpl;

	@GetMapping("/genotp/{voterid}")
	public GenOpResult genOp(@PathVariable("voterid") String voterid) {
		return voterServiceImpl.generateOTPById(voterid);
	}
	
	@GetMapping("/statistics/{course}")
	public VotingStatistics getStatistics(@PathVariable("course") String course) {
		return voterServiceImpl.getStatisticsByCourse(course);
	}
	
	@GetMapping("/statistics/all")
	public VotingStatistics getStatistics() {
		return voterServiceImpl.getOverAllStatistics();
	}

	@PostMapping("/voterequest")
	public VoteResponse requestVote(@RequestBody VoteRequest voteRequest) {
		return voteRequestServiceImpl.requestVote(voteRequest);
	}

	// TODO add error handling for empty candidates i.e. if the voter did'nt voter
	@PostMapping("/castballot")
	public CastBallotResult castBallot(@RequestBody Ballot ballot) {
		List<SsgResult> ssgResults = new ArrayList<>();
		logger.info("BALLOT:" + ballot);
		String voterID = ballot.getVoter();
		voterServiceImpl.updateVoterStatus(voterServiceImpl.getVoterById(voterID).get());

		int presID = ballot.getPres();
		ssgResultServiceImpl.getSsgById(presID).ifPresent(pres -> ssgResults.add(ssgResultServiceImpl.addScore(pres)));
		int vpID = ballot.getVp();
		ssgResultServiceImpl.getSsgById(vpID).ifPresent(vp -> ssgResults.add(ssgResultServiceImpl.addScore(vp)));

		List<Integer> sen = ballot.getSen();
		for (int senID : sen) {
			ssgResultServiceImpl.getSsgById(senID)
					.ifPresent(senator -> ssgResults.add(ssgResultServiceImpl.addScore(senator)));
		}

		List<Integer> rep = ballot.getRep();
		for (int repID : rep) {
			ssgResultServiceImpl.getSsgById(repID)
					.ifPresent(representative -> ssgResults.add(ssgResultServiceImpl.addScore(representative)));
		}

		ssgResultServiceImpl.insertResults(ssgResults);

		return new CastBallotResult("Success");
	}

	@GetMapping("/tryCastballot")
	public Ballot tryCastBallot() {
		Ballot bal = new Ballot("120927", 3, 1, Arrays.asList(5, 6, 7), Arrays.asList(15, 16));
		return bal;
	}

	

}
