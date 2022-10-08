package com.hataraki.backend.joblisting;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JobListingService {

  private final JobListingRepository jobListingRepository;
  private final ModelMapper modelMapper;

  public List<JobListing> getJobListings() {
    return this.jobListingRepository.findAll();
  }

  public JobListing createJobListing(CreateJobListingDto reqDto) {
    // TODO: get user id from token
    String createdBy = "5f9f9f9f9f9f9f9f9f9f9f9f";

    JobListing jobListing = modelMapper.map(reqDto, JobListing.class);
    jobListing.setCreatedBy(createdBy);
    jobListing.setCreatedAt(LocalDateTime.now());
    jobListing.setUpdatedAt(LocalDateTime.now());
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
    jl.setUpdatedAt(LocalDateTime.now());
    return this.jobListingRepository.save(jl);
  }

  public JobListing deleteJobListing(String id) {
    JobListing jobListing = getJobListingById(id);
    jobListingRepository.deleteById(id);
    return jobListing;
  }

  public JobListing getJobListingById(String id) {
    return jobListingRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Listing not found"));
  }

  public List<JobListing> getJobListingsByCreatedBy(String createdBy) {
    return jobListingRepository.findByCreatedBy(createdBy);
  }
}
