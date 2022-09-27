package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
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
  @Autowired
  private ModelMapper modelMapper;

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
