package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hataraki.backend.joblisting.JobListing;
import com.hataraki.backend.joblisting.JobListingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JobApplicationService {
  private final JobApplicationRepository jobApplicationRepository;
  private final JobListingService jobListingService;
  private final ModelMapper modelMapper;

  public List<JobApplication> getJobApplications() {
    return this.jobApplicationRepository.findAll();
  }

  public JobApplication createJobApplication(CreateJobApplicationReqDto req) {
    // TODO: get user id from token
    String userId = "123";
    JobListing jl = this.jobListingService.getJobListingById(req.getJobListingId());
    // set model mapper to skip setting jobListingId on id field
    // NB: NoArgsConstructor must be defined on JobApplication
    JobApplication jobApplication = modelMapper.typeMap(CreateJobApplicationReqDto.class, JobApplication.class)
        .addMappings(mapper -> {
          mapper.skip(JobApplication::setId);
        }).map(req);
    jobApplication.setJobListing(jl);
    jobApplication.setCreatedBy(userId);
    jobApplication.setCreatedAt(LocalDateTime.now());
    jobApplication.setUpdatedAt(LocalDateTime.now());
    return this.jobApplicationRepository.insert(jobApplication);
  }
}
