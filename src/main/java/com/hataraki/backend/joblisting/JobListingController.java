package com.hataraki.backend.joblisting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/job-listings")
public class JobListingController {

    @Autowired
    private JobListingService jobListingService;

    @GetMapping
    public List<JobListing> getJobListings() {
        return this.jobListingService.getJobListings();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobListing createJobListing(@RequestBody CreateJobListingDto req) {
        JobListing jl = this.jobListingService.createJobListing(req);
        return jl;
    }

    @PutMapping("/{id}")
    public JobListing updateJobListing(@RequestBody JobListing updatedListing, @PathVariable String id) {
        try {
            // TODO: refactor to DTO
            JobListing jl = this.jobListingService.updateJobListing(id, updatedListing);
            return jl;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJobListing(@PathVariable String id) {
        try {
            this.jobListingService.deleteJobListing(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found");
        }
    }
}
