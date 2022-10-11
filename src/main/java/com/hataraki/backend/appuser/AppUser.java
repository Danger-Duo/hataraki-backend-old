package com.hataraki.backend.appuser;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class AppUser {
  @Id
  private String id;
  private String username;
  private String password;
  private String email;
  private String company;
  private String role;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
