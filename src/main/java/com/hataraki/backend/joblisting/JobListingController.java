package com.hataraki.backend.joblisting;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-listing")
public class JobListingController {
    @PostMapping
    public JobListing createJobListing(@RequestBody JobListing jobListing) {
        return new JobListing(jobListing.getId(), jobListing.getTitle(), jobListing.getDescription(),
                jobListing.getCreatedBy(), jobListing.getDatePosted());
    }
}
