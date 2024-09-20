package com.vladproduction.registrationloginsystemsecuritydbauthentication.repository;

import com.vladproduction.registrationloginsystemsecuritydbauthentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
