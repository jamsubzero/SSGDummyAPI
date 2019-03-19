package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, String>{
	
	Optional<Voter> findVoterByIdAndOtp(String id, String otp);
	
}
