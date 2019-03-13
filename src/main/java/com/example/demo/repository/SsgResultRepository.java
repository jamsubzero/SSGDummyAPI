package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SsgResult;

public interface SsgResultRepository extends JpaRepository<SsgResult, Integer>{
	
    public List<SsgResult> findAllByPosition(String position);
	

}
