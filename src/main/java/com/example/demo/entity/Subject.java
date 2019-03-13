package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	@GeneratedValue
	private int studentid;
	private String subj;
	private String descript;
	private int unit;
	
	public Subject() {
		super();
	}
	
	public Subject(String subj, String descript, int unit) {
		super();
		this.subj = subj;
		this.descript = descript;
		this.unit = unit;
	}
	public Subject(int studentid, String subj, String descript, int unit) {
		super();
		this.studentid = studentid;
		this.subj = subj;
		this.descript = descript;
		this.unit = unit;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getSubj() {
		return subj;
	}
	public void setSubj(String subj) {
		this.subj = subj;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Subject [studentid=" + studentid + ", subj=" + subj + ", descript=" + descript + ", unit=" + unit + "]";
	}
	
	
	
	
}
