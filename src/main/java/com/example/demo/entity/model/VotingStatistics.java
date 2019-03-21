package com.example.demo.entity.model;

public class VotingStatistics {

	long population;
	long voted;
	float percentage;
	
	
	public VotingStatistics(long population, long voted, float percentage) {
		this.population = population;
		this.voted = voted;
		this.percentage = percentage;
	}


	public long getPopulation() {
		return population;
	}


	public void setPopulation(long population) {
		this.population = population;
	}


	public long getVoted() {
		return voted;
	}


	public void setVoted(long voted) {
		this.voted = voted;
	}


	public float getPercentage() {
		return percentage;
	}


	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}


	@Override
	public String toString() {
		return "Statisctics [population=" + population + ", voted=" + voted + ", percentage=" + percentage + "]";
	}
	
	
	
}
