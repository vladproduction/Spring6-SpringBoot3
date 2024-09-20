package com.vladproduction.registrationloginsystemsecuritydbauthentication.repository;

import com.vladproduction.registrationloginsystemsecuritydbauthentication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
