package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Configuration;

public interface ConfigurationService {

	 Configuration setConfiguration(Configuration configuration);
	 Optional<Configuration> getVotingStatus();
}
