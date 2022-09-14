package com.hataraki.backend.jobapplication;

import java.util.Date;

public class JobApplication {

    private long id;
    private String firstName;
    private String lastName;
    private String resumeLink;
    private long createdBy;
    private Date dateApplied;

    public JobApplication(long id, String firstName, String lastName, String resumeLink, long createdBy,
            Date dateApplied) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resumeLink = resumeLink;
        this.createdBy = createdBy;
        this.dateApplied = dateApplied;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public long getCreatedBy() {
        return createdBy;
    }

}
