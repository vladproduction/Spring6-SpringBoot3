package com.vladproduction.springbootrestfullwebservicesactuatorapi.repository;


import com.vladproduction.springbootrestfullwebservicesactuatorapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
