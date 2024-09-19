package com.vladproduction.todomanagement.repository;

import com.vladproduction.todomanagement.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
