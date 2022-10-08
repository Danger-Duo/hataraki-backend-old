package com.hataraki.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hataraki.backend.appuser.AppUserRepository;
import com.hataraki.backend.jobapplication.JobApplicationRepository;
import com.hataraki.backend.joblisting.JobListingRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { AppUserRepository.class, JobApplicationRepository.class,
		JobListingRepository.class })
@Slf4j
public class HatarakiBackendApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(HatarakiBackendApplication.class, args);
		log.info("Hataraki Backend started!");
	}
}
