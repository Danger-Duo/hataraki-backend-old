package com.hataraki.backend.joblisting;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "joblistings")
public class JobListing {
    @Id
    private String id;
    private String title;
    private String description;
    private String location;
    private String startDate;
    private String employmentType;
    // TODO: reference to user collection
    // @DBRef
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
