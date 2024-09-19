package com.vladproduction.springbootrestfullwebserviceshandlingexceptions.repository;


import com.vladproduction.springbootrestfullwebserviceshandlingexceptions.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
