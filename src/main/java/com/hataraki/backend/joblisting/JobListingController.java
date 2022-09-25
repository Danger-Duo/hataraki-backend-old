package com.hataraki.backend.joblisting;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @PutMapping("/{id}")
    public JobListing updateJobListing(@RequestBody JobListing updatedListing, @PathVariable String id) {
        JobListing jl = this.jobListingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found"));
        jl.setTitle(updatedListing.getTitle());
        jl.setDescription(updatedListing.getDescription());
        jl.setLocation(updatedListing.getLocation());
        jl.setEmploymentType(updatedListing.getEmploymentType());
        jl.setStartDate(updatedListing.getStartDate());
        jl = this.jobListingRepository.save(jl);
        return jl;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJobListing(@PathVariable String id) {
        JobListing jl = this.jobListingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found"));
        this.jobListingRepository.delete(jl);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
