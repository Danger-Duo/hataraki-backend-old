package com.hataraki.backend.joblisting;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public JobListing(String title, String description, String location, String startDate, String employmentType,
            String createdBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.employmentType = employmentType;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
