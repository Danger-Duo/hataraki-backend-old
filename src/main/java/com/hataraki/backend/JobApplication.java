package com.hataraki.backend;

import java.util.Date;

public class JobApplication {

    private long id;
    private String name;
    private Date date;
    private String resumeLink;

    public JobApplication(long id, String name, Date date, String resumeLink) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.resumeLink = resumeLink;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getResumeLink() {
        return resumeLink;
    }

}
