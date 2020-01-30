package com.stephenhiggins.pokemon_store_backend.repos;

import com.stephenhiggins.pokemon_store_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long> {
  User findByEmail(String emailToTry);
}
