package com.hataraki.backend.joblisting;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobListingService {

  @Autowired
  private JobListingRepository jobListingRepository;

  public List<JobListing> getJobListings() {
    return this.jobListingRepository.findAll();
  }

  public JobListing createJobListing(CreateJobListingDto reqDto) {
    // TODO: get user id from token
    String createdBy = "5f9f9f9f9f9f9f9f9f9f9f9f";
    JobListing jobListing = new JobListing(reqDto.getTitle(), reqDto.getDescription(), reqDto.getLocation(),
        reqDto.getStartDate(), reqDto.getEmploymentType(), createdBy, LocalDateTime.now(), LocalDateTime.now());
    return jobListingRepository.save(jobListing);
  }

  public JobListing updateJobListing(String jobListingId, JobListing jobListing) {
    // TODO: get user id from token
    JobListing jl = this.getJobListingById(jobListingId);
    jl.setTitle(jobListing.getTitle());
    jl.setDescription(jobListing.getDescription());
    jl.setLocation(jobListing.getLocation());
    jl.setEmploymentType(jobListing.getEmploymentType());
    jl.setStartDate(jobListing.getStartDate());
    jl.setUpdatedOn(LocalDateTime.now());
    return this.jobListingRepository.save(jl);
  }

  public JobListing deleteJobListing(String id) {
    JobListing jobListing = jobListingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Job listing not found"));
    jobListingRepository.deleteById(id);
    return jobListing;
  }

  public JobListing getJobListingById(String id) {
    return jobListingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Job listing not found"));
  }

  public List<JobListing> getJobListingsByCreatedBy(String createdBy) {
    return jobListingRepository.findByCreatedBy(createdBy);
  }
}
