package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voter {

	@Id
	String id;
	String name;
	String course;
	int voted;	
	
	public Voter() {
		super();
	}

	public Voter(String name, String course, int voted) {
		super();
		this.name = name;
		this.course = course;
		this.voted = voted;
	}

	public Voter(String id, String name, String course, int voted) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.voted = voted;
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
	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", course=" + course + ", voted=" + voted + "]";
	}
	
	
	
	
	
	
	
}
