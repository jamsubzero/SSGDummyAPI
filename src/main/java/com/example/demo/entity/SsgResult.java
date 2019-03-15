package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SsgResult {

	@Id
	@GeneratedValue
	private int id;
	private String position;
	private String name;
	private int score;
	
	
	public SsgResult() {
		super();
	}

	public SsgResult(int id, String position, String name, int score) {
		this.id = id;
		this.position = position;
		this.name = name;
		this.score = score;
	
	}
	
	public SsgResult(String position, String name, int score) {
		this.position = position;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Ssgresult [id=" + id + ", position=" + position + ", name=" + name + ", score=" + score + "]";
	}
	
	
	
}
