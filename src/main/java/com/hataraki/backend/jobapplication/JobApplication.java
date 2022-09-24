package com.hataraki.backend.jobapplication;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "jobapplications")
public class JobApplication {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String startDate;
    private String resumeLink;
    private String personalStatement;
    private String createdBy;
    private Date dateApplied;

    public JobApplication(String firstName, String lastName, String email, String startDate,
            String resumeLink, String personalStatement, String createdBy,
            Date dateApplied) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.startDate = startDate;
        this.resumeLink = resumeLink;
        this.personalStatement = personalStatement;
        this.createdBy = createdBy;
        this.dateApplied = dateApplied;
    }
}
