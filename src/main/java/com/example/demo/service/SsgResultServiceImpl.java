package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SsgResult;
import com.example.demo.repository.SsgResultRepository;

@Service
public class SsgResultServiceImpl implements SsgResultService {

	@Autowired
	SsgResultRepository ssgResultRepository;

	@Override
	public List<SsgResult> getSsgResultByPos(String position) {
		return	ssgResultRepository.findAllByPosition(position);
	}

	@Override
	public List<SsgResult> getAllSsgResult() {
		return  ssgResultRepository.findAll();
	}

	@Override
	public List<SsgResult> insertResults(List<SsgResult> entities) {
		return ssgResultRepository.saveAll(entities);
	}
	
	
	
}
