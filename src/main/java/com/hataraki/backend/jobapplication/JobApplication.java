package com.hataraki.backend.jobapplication;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hataraki.backend.joblisting.JobListing;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "jobapplications")
@NoArgsConstructor
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
}
