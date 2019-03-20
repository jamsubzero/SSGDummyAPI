package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Configuration {

	@Id
	int configId;
	int votingStatus;
	
	public Configuration() {
	}
	public Configuration(int configId, int votingStatus) {
		this.configId = configId;
		this.votingStatus = votingStatus;
	}
	public int getConfigId() {
		return configId;
	}
	public void setConfigId(int configId) {
		this.configId = configId;
	}
	public int getVotingStatus() {
		return votingStatus;
	}
	public void setVotingStatus(int votingStatus) {
		this.votingStatus = votingStatus;
	}

	@Override
	public String toString() {
		return "Configuration [configId=" + configId + ", votingStatus=" + votingStatus + "]";
	}
	
	@PrePersist
	void preInsert() {
	   this.votingStatus = 0;
	}
	
}
