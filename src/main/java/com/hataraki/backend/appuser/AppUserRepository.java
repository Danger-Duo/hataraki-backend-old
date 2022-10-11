package com.hataraki.backend.appuser;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {
  Optional<AppUser> findByUsername(String username);

  Optional<AppUser> findByEmail(String email);
}
