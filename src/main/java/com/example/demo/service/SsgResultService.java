package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.SsgResult;

public interface SsgResultService {

	List<SsgResult> getSsgResultByPos(String position);
	List<SsgResult> getSsgByPos(String position);
	List<SsgResult> getAllSsgResult();
	List<SsgResult> insertResults(List<SsgResult> results);
	Optional<SsgResult> getSsgById(int id);
	SsgResult addScore(SsgResult ssgResult);
	
}
