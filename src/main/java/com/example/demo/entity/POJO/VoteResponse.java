package com.example.demo.entity.POJO;

/**
 * 
 * @author jamsubzero
 * 
 * a simple POJO forwarded back to the client when the vote request service is triggered 
 * 
 */

public class VoteResponse {
	
	String id;
	String name;
	String course;
	int voted;
	int exist;
	
	public VoteResponse() {
		super();
	}

	public VoteResponse(String id, String name, String course, int voted, int exist) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.voted = voted;
		this.exist = exist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getVoted() {
		return voted;
	}

	public void setVoted(int voted) {
		this.voted = voted;
	}

	public int getExist() {
		return exist;
	}

	public void setExist(int exist) {
		this.exist = exist;
	}

	@Override
	public String toString() {
		return "VoteResponse [id=" + id + ", name=" + name + ", course=" + course + ", voted=" + voted + ", exist="
				+ exist + "]";
	}
	
	
	
	
	

}
