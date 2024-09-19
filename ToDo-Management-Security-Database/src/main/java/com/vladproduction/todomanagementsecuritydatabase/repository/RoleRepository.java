package com.vladproduction.todomanagementsecuritydatabase.repository;

import com.vladproduction.todomanagementsecuritydatabase.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
