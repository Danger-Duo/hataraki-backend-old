package com.hataraki.backend.jobapplication;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

}
