package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SsgResult;

public interface SsgResultService {

	List<SsgResult> getSsgResultByPos(String position);
	List<SsgResult> getAllSsgResult();
	List<SsgResult> insertResults(List<SsgResult> results);
	
}
