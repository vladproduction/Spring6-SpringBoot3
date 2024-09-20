package com.vladproduction.registrationloginsystemsecuritymvc.repository;

import com.vladproduction.registrationloginsystemsecuritymvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
