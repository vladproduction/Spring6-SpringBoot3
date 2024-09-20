package com.vladproduction.springbootwebfluxtutorial.repository;

import com.vladproduction.springbootwebfluxtutorial.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
