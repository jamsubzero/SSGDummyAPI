package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.SsgResult;

public interface SsgResultRepository extends JpaRepository<SsgResult, Integer>{
	
    public List<SsgResult> findByPositionOrderByScoreDesc(String position);
    public List<SsgResult> findByPositionOrderByNameAsc(String position);
    
    @Transactional
	@Modifying
	@Query("update SsgResult ssg set ssg.score = ?1")
	int setScoreForSsgResult(Integer score);

}
