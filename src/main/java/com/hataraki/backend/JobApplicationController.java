package com.hataraki.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JobApplicationController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/job-application")
    public JobApplication jobApplication(@RequestParam(value = "name", defaultValue = "empty") String name) {
        return new JobApplication(counter.incrementAndGet(), name, new Date(), "https://www.google.com");
    }
}
