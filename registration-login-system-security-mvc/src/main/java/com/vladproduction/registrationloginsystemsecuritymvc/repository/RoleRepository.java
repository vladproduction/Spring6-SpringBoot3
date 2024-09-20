package com.vladproduction.registrationloginsystemsecuritymvc.repository;

import com.vladproduction.registrationloginsystemsecuritymvc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
