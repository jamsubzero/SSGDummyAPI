package com.example.demo.entity.model;

/**
 * 
 * @author jamsubzero
 *
 * A simple POJO for accepting vote request from the client, contains only the id of the student
 *
 */

public class VoteRequest {
	
	
	private String id;
	
	public VoteRequest() { 
	}

	public VoteRequest(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "VoteRequest [id=" + id + "]";
	}
	
	
    	

}
