package com.hataraki.backend.jobapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobApplicationReqDto {
  // TODO: integrate with modelmapper
  private String firstName;
  private String lastName;
  private String email;
  private String startDate;
  private String resumeLink;
  private String personalStatement;
  private String jobListingId;

}
