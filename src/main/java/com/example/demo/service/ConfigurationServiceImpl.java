package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Configuration;
import com.example.demo.repository.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{
	
	public static final int DEFAULT_VOTING_CONFIG_ID = 1;
	public static final int VOTING_STATUS_OPEN = 1;
	public static final int VOTING_STATUS_CLOSE = 0;
	
	@Autowired
	ConfigurationRepository configurationRepository; 

	@Override
	public Configuration setConfiguration(Configuration configuration) {
		return configurationRepository.save(configuration);
	}
	
	@Override
	public Optional<Configuration> getVotingStatus() {
		return configurationRepository.findById(DEFAULT_VOTING_CONFIG_ID);
	}
	
	
	

}
