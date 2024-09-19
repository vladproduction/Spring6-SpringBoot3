package com.vladproduction.springbootrestfullwebservicesmodelmapper.repository;

import com.vladproduction.springbootrestfullwebservicesmodelmapper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
