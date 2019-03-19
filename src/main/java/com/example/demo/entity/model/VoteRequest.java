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
	private String otp;
	
	public VoteRequest() { 
	}

	public VoteRequest(String id, String otp) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "VoteRequest [id=" + id + ", otp=" + otp + "]";
	}

	
	
	
    	

}
