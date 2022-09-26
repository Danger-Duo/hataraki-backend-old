package com.hataraki.backend.jobapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplication> getJobApplications() {
        // TODO: filter by user
        return this.jobApplicationService.getJobApplications();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplication createJobApplication(@RequestBody CreateJobApplicationReqDto req) {
        // get job listing by jobListingId, 404 response if not found
        try {
            return this.jobApplicationService.createJobApplication(req);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found");
        }
    }
}
