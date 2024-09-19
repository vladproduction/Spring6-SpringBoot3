package com.vladproduction.todomanagementsecuritydatabase.service;

import com.vladproduction.todomanagementsecuritydatabase.dto.ToDoDto;

import java.util.List;

public interface ToDoService {

    ToDoDto addToDo(ToDoDto toDoDto);
    ToDoDto getToDo(Long id);
    List<ToDoDto> getAllToDos();
    ToDoDto updateToDo(ToDoDto toDoDto, Long id);
    void deleteToDo(Long id);
    ToDoDto completeToDo(Long id);
    ToDoDto inCompleteToDo(Long id);


}
