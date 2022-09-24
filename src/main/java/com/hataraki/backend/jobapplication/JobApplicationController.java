package com.hataraki.backend.jobapplication;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        JobApplication ja = this.jobApplicationRepository.save(jobApplication);
        return ja;
    }
}
