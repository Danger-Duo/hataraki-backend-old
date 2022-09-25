package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hataraki.backend.joblisting.JobListing;

@RestController
@RequestMapping("/api/v1/job-applications")
public class JobApplicationController {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationController(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @GetMapping
    public List<JobApplication> getJobApplications() {
        return this.jobApplicationRepository.findAll();
    }

    @PostMapping
    public JobApplication createJobApplication(@RequestBody CreateJobApplicationReqDto req) {
        // TODO: get job listing by jobListingId, throw exception if not found
        JobListing jl = new JobListing();
        JobApplication jobApplication = new JobApplication(
                jl,
                req.getFirstName(),
                req.getLastName(),
                req.getEmail(),
                req.getStartDate(),
                req.getResumeLink(),
                req.getPersonalStatement(),
                "user-id",
                LocalDateTime.now(),
                LocalDateTime.now());
        return this.jobApplicationRepository.save(jobApplication);
    }
}
