package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
