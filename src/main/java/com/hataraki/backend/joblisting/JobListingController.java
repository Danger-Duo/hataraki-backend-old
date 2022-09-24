package com.hataraki.backend.joblisting;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-listings")
public class JobListingController {

    private final JobListingRepository jobListingRepository;

    public JobListingController(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }

    @GetMapping
    public List<JobListing> getJobListings() {
        return this.jobListingRepository.findAll();
    }

    @PostMapping
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        JobListing jl = this.jobListingRepository.save(jobListing);
        return jl;
    }
}
