package com.hataraki.backend.security;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtReqDto implements Serializable {
  private static final long serialVersionUID = 5926468583005150707L;
  private String username;
  private String password;
}