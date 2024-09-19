package com.vladproduction.todomanagementwithsecurity.repository;

import com.vladproduction.todomanagementwithsecurity.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
