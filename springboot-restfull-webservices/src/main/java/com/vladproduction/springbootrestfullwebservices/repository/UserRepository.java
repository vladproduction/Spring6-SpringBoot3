package com.vladproduction.springbootrestfullwebservices.repository;

import com.vladproduction.springbootrestfullwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
