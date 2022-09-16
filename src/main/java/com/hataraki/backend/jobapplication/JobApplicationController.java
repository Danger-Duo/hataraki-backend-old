package com.hataraki.backend.jobapplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/job-application")
public class JobApplicationController {
    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplication jobApplication) {
        return new JobApplication(jobApplication.getId(),
                jobApplication.getFirstName(),
                jobApplication.getLastName(), jobApplication.getResumeLink(),
                jobApplication.getCreatedBy(),
                jobApplication.getDateApplied());
    }
}
