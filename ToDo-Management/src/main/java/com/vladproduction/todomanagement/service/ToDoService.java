package com.vladproduction.todomanagement.service;

import com.vladproduction.todomanagement.dto.ToDoDto;

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
