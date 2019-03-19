package com.example.demo.entity.model;

import com.example.demo.entity.Voter;

public class GenOpResult {

	int status;
	Voter voter;
	
	public GenOpResult(int status, Voter voter) {
		this.status = status;
		this.voter = voter;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Voter getVoter() {
		return voter;
	}

	public void setVoter(Voter voter) {
		this.voter = voter;
	}

	@Override
	public String toString() {
		return "GenOpResult [status=" + status + ", voter=" + voter + "]";
	}
		
	
}
