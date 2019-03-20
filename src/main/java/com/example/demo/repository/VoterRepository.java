package com.example.demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String>{
	
	Optional<Voter> findVoterByIdAndOtp(String id, String otp);
	
	@Transactional
	@Modifying
	@Query("update Voter v set v.voted = ?1, v.otp = ?2 ")
	int setVotedAndOtpForVoter(Integer voted, String otp);
	
}
