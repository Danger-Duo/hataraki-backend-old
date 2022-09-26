package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hataraki.backend.joblisting.JobListing;
import com.hataraki.backend.joblisting.JobListingService;

@Service
public class JobApplicationService {
  @Autowired
  private JobApplicationRepository jobApplicationRepository;
  @Autowired
  private JobListingService jobListingService;

  public List<JobApplication> getJobApplications() {
    return this.jobApplicationRepository.findAll();
  }

  public JobApplication createJobApplication(CreateJobApplicationReqDto req) {
    // TODO: get user id from token
    String userId = "123";
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
  }
}
