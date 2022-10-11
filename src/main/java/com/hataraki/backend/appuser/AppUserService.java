package com.hataraki.backend.appuser;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AppUserService {
  private final AppUserRepository appUserRepository;

  public AppUser saveUser(AppUser appUser) {
    return appUserRepository.save(appUser);
  }

  public AppUser getUserById(String id) {
    return appUserRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + " does not exist"));
  }

  public AppUser getUserByEmail(String email) {
    return appUserRepository.findByEmail(email)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with email " + email + " does not exist"));
  }

  public AppUser getUserByUsername(String username) {
    return appUserRepository.findByUsername(username)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "User with username " + username + " does not exist"));
  }
}
