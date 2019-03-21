package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
		return	ssgResultRepository.findByPositionOrderByScoreDesc(position);
	}

	@Override
	public List<SsgResult> getAllSsgResult() {
		return  ssgResultRepository.findAll();
	}

	@Override
	public List<SsgResult> insertResults(List<SsgResult> entities) {
		return ssgResultRepository.saveAll(entities);
	}

	@Override
	public List<SsgResult> getSsgByPos(String position) {
        return ssgResultRepository.findByPositionOrderByNameAsc(position);
	}

	@Override
	public Optional<SsgResult> getSsgById(int id) {
		return ssgResultRepository.findById(id);
	}

	@Override
	public SsgResult addScore(SsgResult ssgResult) {
		int newScore = ssgResult.getScore() + 1;
		ssgResult.setScore(newScore);
		return ssgResult;
	}
	
	

	@Override
	public SsgResult insertOrSaveSsgResult(SsgResult ssgResult) {
		return ssgResultRepository.save(ssgResult);
	}

	@Override
	public void deleteSsgResultById(int id) {
		ssgResultRepository.deleteById(id);
	}

	@Override
	public int reZeroSsgResult(Integer score) {
	
		return ssgResultRepository.setScoreForSsgResult(0);
	}

	
	
	
	
	
	
}
