package com.vladproduction.springbootrestfullwebservicesdto.repository;

import com.vladproduction.springbootrestfullwebservicesdto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
