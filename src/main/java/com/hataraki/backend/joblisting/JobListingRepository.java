package com.hataraki.backend.joblisting;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobListingRepository extends MongoRepository<JobListing, String> {

}
