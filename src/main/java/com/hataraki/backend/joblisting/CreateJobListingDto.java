package com.hataraki.backend.joblisting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobListingDto {
  private String title;
  private String description;
  private String location;
  private String startDate;
  private String employmentType;
}
