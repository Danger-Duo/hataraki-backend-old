package com.hataraki.backend.joblisting;

import java.util.Date;

public class JobListing {
    private long id;
    private String title;
    private String description;
    private long createdBy;
    private Date datePosted;

    public JobListing(long id, String title, String description, long createdBy, Date datePosted) {
        this.id = id;
        this.title = title;
        this.description = description;
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

    public long getCreatedBy() {
        return createdBy;
    }

    public Date getDatePosted() {
        return datePosted;
    }
}
