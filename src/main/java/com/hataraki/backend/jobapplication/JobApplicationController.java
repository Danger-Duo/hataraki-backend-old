package com.hataraki.backend.jobapplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JobApplicationController {
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/job-application")
    public JobApplication jobApplication(@RequestBody JobApplication jobApplication) {
        return new JobApplication(counter.incrementAndGet(), jobApplication.getFirstName(),
                jobApplication.getLastName(), jobApplication.getResumeLink(), jobApplication.getCreatedBy(),
                jobApplication.getDateApplied());
    }
}
