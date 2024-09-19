package com.vladproduction.springbootrestfullwebservicesmapstruct.repository;


import com.vladproduction.springbootrestfullwebservicesmapstruct.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
