package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int stdid;
	private String name;
	private String course;
	private int age;
	
	
	public Student() {
		super();
	}
	
	public Student(String name, String course, int age) {
		super();
		this.name = name;
		this.course = course;
		this.age = age;
	}
	
	public Student(int stdid, String name, String course, int age) {
		super();
		this.stdid = stdid;
		this.name = name;
		this.course = course;
		this.age = age;
	}
	
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", name=" + name + ", course=" + course + ", age=" + age + "]";
	}
	
	
	
	
	
}
