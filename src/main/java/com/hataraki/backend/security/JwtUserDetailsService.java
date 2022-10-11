package com.hataraki.backend.security;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.hataraki.backend.appuser.AppUser;
import com.hataraki.backend.appuser.AppUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
  private final AppUserService appUserService;

  @Override
  public UserDetails loadUserByUsername(String username) {
    AppUser appUser = appUserService.getUserByUsername(username);
    // TODO: add roles for user
    return new User(appUser.getUsername(), appUser.getPassword(), List.of());
  }
}
