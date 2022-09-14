package com.hataraki.backend.jobapplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApplicationController {
    @PostMapping("/job-application")
    public JobApplication jobApplication(@RequestBody JobApplication jobApplication) {
        return new JobApplication(jobApplication.getId(), jobApplication.getFirstName(),
                jobApplication.getLastName(), jobApplication.getResumeLink(), jobApplication.getCreatedBy(),
                jobApplication.getDateApplied());
    }
}
