package com.hataraki.backend.joblisting;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobListingRepository extends MongoRepository<JobListing, String> {
  List<JobListing> findByCreatedBy(String createdBy);
}
