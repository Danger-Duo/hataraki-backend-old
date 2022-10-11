package com.hataraki.backend.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController("/api/v1/auth")
@RequiredArgsConstructor
public class JwtAuthController {
  /**
   * Basic authentication controller that issues JWT.
   */
  private AuthenticationManager authenticationManager;

  private JwtTokenUtil jwtTokenUtil;

  private JwtUserDetailsService userDetailsService;

  // set public endpoint for authentication
  @PostMapping
  public JwtResDto createAuthenticationToken(@RequestBody JwtReqDto authReq) throws Exception {

    authenticate(authReq.getUsername(), authReq.getPassword());

    final UserDetails userDetails = userDetailsService
        .loadUserByUsername(authReq.getUsername());

    final String token = jwtTokenUtil.generateToken(userDetails);

    return new JwtResDto(token);
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
