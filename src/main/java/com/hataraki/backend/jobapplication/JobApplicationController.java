package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
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

import com.hataraki.backend.joblisting.JobListing;
import com.hataraki.backend.joblisting.JobListingService;

@RestController
@RequestMapping("/api/v1/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private JobListingService jobListingService;

    @GetMapping
    public List<JobApplication> getJobApplications() {
        // TODO: filter by user
        return this.jobApplicationRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobApplication createJobApplication(@RequestBody CreateJobApplicationReqDto req) {
        // TODO: get user id from token
        String userId = "123";
        // get job listing by jobListingId, 404 response if not found
        try {
            JobListing jl = this.jobListingService.getJobListingById(req.getJobListingId());
            JobApplication jobApplication = new JobApplication(
                    jl,
                    req.getFirstName(),
                    req.getLastName(),
                    req.getEmail(),
                    req.getStartDate(),
                    req.getResumeLink(),
                    req.getPersonalStatement(),
                    userId,
                    LocalDateTime.now(),
                    LocalDateTime.now());
            return this.jobApplicationRepository.save(jobApplication);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found");
        }
    }
}
