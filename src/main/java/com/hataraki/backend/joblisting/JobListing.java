package com.hataraki.backend.joblisting;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "joblistings")
public class JobListing {
    @Id
    private long id;
    private String title;
    private String description;
    private String location;
    private Date startDate;
    private String employmentType;
    private long createdBy;
    private Date datePosted;

    public JobListing(String title, String description, String location, Date startDate, String employmentType, long createdBy, Date datePosted) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.startDate = startDate;
        this.employmentType = employmentType;
        this.createdBy = createdBy;
        this.datePosted = datePosted;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getEmploymentType() {
        return employmentType;
    }
    
    public long getCreatedBy() {
        return createdBy;
    }

    public Date getDatePosted() {
        return datePosted;
    }
}
