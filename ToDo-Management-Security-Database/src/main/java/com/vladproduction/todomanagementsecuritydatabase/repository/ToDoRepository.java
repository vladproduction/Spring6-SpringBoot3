package com.vladproduction.todomanagementsecuritydatabase.repository;

import com.vladproduction.todomanagementsecuritydatabase.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
