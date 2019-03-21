package com.example.demo.service;

import java.text.DecimalFormat;
import java.util.Optional;
import java.util.Random;

import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Voter;
import com.example.demo.entity.model.GenOpResult;
import com.example.demo.entity.model.VotingStatistics;
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
	public GenOpResult generateOTPById(String id) {
		 Optional<Voter> voter = voterRepository.findById(id);
		 int status = 0; // not exists, by default
         Voter thevoter = null;
//String id, String name, String course, String otp, int voted
		 if(voter.isPresent()) {
			 if(voter.get().getVoted()==0) { //if not yet voted
				 voter.get().setOtp(generateOTP(7)); // 7 digits
				voterRepository.save(voter.get()); // persists to DB
				 thevoter = voter.get();
				 status = 1; //success
			 }else {
				 thevoter = new Voter("-", "-", "-", "-",  -1);
				 status = 3; // already generated
			 } 
		 }else { //if ID does not exists
			 thevoter = new Voter("-", "-", "-", "-",  -1);
		 }
		 
		return new GenOpResult(status, thevoter);
	}

	
	
	@Override
	public Optional<Voter> getVoterById(String id) {
		return voterRepository.findById(id);
	}
	

	@Override
	public int reZeroVoter(Integer voted, String otp) {
		return voterRepository.setVotedAndOtpForVoter(voted, otp);
	}
	
	
	  private String generateOTP(int length) {
	      String numbers = "1234567890";
	      Random random = new Random();
	      char[] otp = new char[length];

	      for(int i = 0; i< length ; i++) {
	         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
	      }
	      return String.valueOf(otp);
	   }

	@Override
	public VotingStatistics getStatisticsByCourse(String course) {
		// IT,  BA, ED, FI, CRIM
		String courseKey = "";
		if(course.equals("IT")) {
			courseKey = "BSI%";
		}else if(course.equals("ED")) {
			courseKey = "%ED%";
		}else if(course.equals("BA")) {
			courseKey = "%BA%";
		}else if(course.equals("CRIM")) {
			courseKey = "%CRIM%";
		}else if(course.equals("FI")) {
			courseKey = "%FI%";
		}

		long population = voterRepository.countVoterByCourse(courseKey);
		long voted = voterRepository.countVoterByCourseAndVoted(courseKey, VOTED_STATUS);
		float percentage = 0;
		try {
		DecimalFormat df = new DecimalFormat("#.##");
		percentage = Float.parseFloat(df.format((  ((float)voted) /  ((float)population)) * 100));
		System.out.println("POP:" + population+ ", VOTED: "+ voted + ", PERCENTAGE:" + percentage);
		}catch (NumberFormatException ex){
			percentage = 0;	
		}
		return new VotingStatistics(population, voted,  percentage);
	}

	@Override
	public VotingStatistics getOverAllStatistics() {
		Long population = voterRepository.count();
		Long voted = voterRepository.countVoterByVoted(VOTED_STATUS);
		float percentage = 0;
		try {
		DecimalFormat df = new DecimalFormat("#.##");
		percentage = Float.parseFloat(df.format((  ((float)voted) /  ((float)population)) * 100));
		System.out.println("POP:" + population+ ", VOTED: "+ voted + ", PERCENTAGE:" + percentage);
		}catch (NumberFormatException ex){
			percentage = 0;	
		}
		return new VotingStatistics(population, voted,  percentage);
	}

	
	

	
	
}
