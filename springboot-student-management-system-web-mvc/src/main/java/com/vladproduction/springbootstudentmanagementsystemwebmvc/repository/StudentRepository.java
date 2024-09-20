package com.vladproduction.springbootstudentmanagementsystemwebmvc.repository;

import com.vladproduction.springbootstudentmanagementsystemwebmvc.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
