package com.example.demo.entity.model;

import java.util.List;

public class Ballot {

	String voter;
	int pres;
	int vp;
	List<Integer> sen;
	List<Integer> rep;
	
	public Ballot(String voter, int pres, int vp, List<Integer> sen, List<Integer> rep) {
		this.voter = voter;
		this.pres = pres;
		this.vp = vp;
		this.sen = sen;
		this.rep = rep;
	}
		
	public String getVoter() {
		return voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

	public int getPres() {
		return pres;
	}
	public void setPres(int pres) {
		this.pres = pres;
	}
	public int getVp() {
		return vp;
	}
	public void setVp(int vp) {
		this.vp = vp;
	}
	public List<Integer> getSen() {
		return sen;
	}
	public void setSen(List<Integer> sen) {
		this.sen = sen;
	}
	public List<Integer> getRep() {
		return rep;
	}
	public void setRep(List<Integer> rep) {
		this.rep = rep;
	}
	
	@Override
	public String toString() {
		return "Ballot [voter=" + voter + ", pres=" + pres + ", vp=" + vp + ", sen=" + sen + ", rep=" + rep + "]";
	}
	
	
	
	
}
