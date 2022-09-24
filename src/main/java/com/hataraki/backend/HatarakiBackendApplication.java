package com.hataraki.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hataraki.backend.jobapplication.JobApplicationRepository;
import com.hataraki.backend.joblisting.JobListingRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { JobApplicationRepository.class, JobListingRepository.class })
public class HatarakiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HatarakiBackendApplication.class, args);
	}
}
