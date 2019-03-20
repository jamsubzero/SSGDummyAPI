package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Configuration;
import com.example.demo.repository.ConfigurationRepository;
import com.example.demo.service.ConfigurationServiceImpl;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	ConfigurationRepository configurationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//if config does not exists
		if(!configurationRepository.existsById(ConfigurationServiceImpl.DEFAULT_VOTING_CONFIG_ID)){
			configurationRepository.save(
					new Configuration(ConfigurationServiceImpl.DEFAULT_VOTING_CONFIG_ID, 
							          ConfigurationServiceImpl.VOTING_STATUS_CLOSE)); // close by default
		}
		
	}
	
	

}

