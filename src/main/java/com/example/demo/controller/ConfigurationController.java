package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Configuration;
import com.example.demo.service.ConfigurationService;
import com.example.demo.service.ConfigurationServiceImpl;

@RestController
@RequestMapping("/config")
@CrossOrigin("*") // allow all client origins
public class ConfigurationController {
	
	@Autowired
	ConfigurationService configurationServiceImpl;
	
	@GetMapping("/votestat/{status}")
	public Configuration setConfiguration(@PathVariable int status) {
	  return configurationServiceImpl.setConfiguration(
			  new Configuration(ConfigurationServiceImpl.DEFAULT_VOTING_CONFIG_ID, status));
	}
	
	@GetMapping("/getstat")
	public Optional<Configuration> getConfiguration() {
	  return configurationServiceImpl.getVotingStatus();
	}
	
	
	
	

}
