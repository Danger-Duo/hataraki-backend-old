package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hataraki.backend.joblisting.JobListing;

import lombok.Data;

@Data
@Document(collection = "jobapplications")
public class JobApplication {

    @Id
    private String id;
    @DBRef
    private JobListing jobListing;
    private String firstName;
    private String lastName;
    private String email;
    private String startDate;
    private String resumeLink;
    private String personalStatement;
    // TODO: reference to user collection
    // @DBRef
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public JobApplication(JobListing jobListing, String firstName, String lastName, String email, String startDate,
            String resumeLink, String personalStatement, String createdBy,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.jobListing = jobListing;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.startDate = startDate;
        this.resumeLink = resumeLink;
        this.personalStatement = personalStatement;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
