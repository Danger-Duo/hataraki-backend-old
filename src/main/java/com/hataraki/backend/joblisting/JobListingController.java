package com.hataraki.backend.joblisting;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobListingController {

    // create job listing endpoint
    @PostMapping("/job-listing")
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return new JobListing(jobListing.getId(), jobListing.getTitle(), jobListing.getDescription(), jobListing.getCreatedBy(), jobListing.getDatePosted());
    }
}
