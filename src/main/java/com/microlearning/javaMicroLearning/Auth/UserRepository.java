package com.microlearning.javaMicroLearning.Auth;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "roles") // fetch roles eagerly
  User findByUsername(String username);
}