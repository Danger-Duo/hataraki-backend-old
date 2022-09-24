package com.hataraki.backend.joblisting;

import java.util.Date;

import org.springframework.data.annotation.Id;
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
    private Date startDate;
    private String employmentType;
    private String createdBy;
    private Date datePosted;

    public JobListing(String title, String description, String location, Date startDate, String employmentType,
            String createdBy, Date datePosted) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.employmentType = employmentType;
        this.createdBy = createdBy;
        this.datePosted = datePosted;
    }
}
