package com.vladproduction.todomanagementsecuritydatabase.controller;

import com.vladproduction.todomanagementsecuritydatabase.dto.ToDoDto;
import com.vladproduction.todomanagementsecuritydatabase.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;

    // [POST]: build add ToDo Entity REST API
    @PreAuthorize("hasRole('ADMIN')") //method level security
    @PostMapping
    public ResponseEntity<ToDoDto> addToDo(@RequestBody ToDoDto toDoDto){
        ToDoDto addedToDo = toDoService.addToDo(toDoDto);
        return new ResponseEntity<>(addedToDo, HttpStatus.CREATED);
    }

    // [GET]: build get ToDo Entity by Id REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<ToDoDto> getToDo(@PathVariable Long id){
        ToDoDto toDoById = toDoService.getToDo(id);
        return new ResponseEntity<>(toDoById, HttpStatus.OK);
    }

    // [GET]: build get all ToDos Entity as List<ToDo>  REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<ToDoDto>> getAllToDos(){
        List<ToDoDto> toDoDtoList = toDoService.getAllToDos();
//        return new ResponseEntity<>(toDoDtoList, HttpStatus.OK);
        return ResponseEntity.ok(toDoDtoList);
    }

    // [PUT]: build update ToDo Entity REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<ToDoDto> updateToDo(@RequestBody ToDoDto toDoDto,
                                              @PathVariable Long id){
        ToDoDto updatedToDo = toDoService.updateToDo(toDoDto, id);
        return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
    }

    // [DELETE]: build delete ToDo Entity REST API
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
        return new ResponseEntity<>("ToDo successfully deleted", HttpStatus.OK);
    }

    // [PATCH]: build complete ToDo Entity REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<ToDoDto> completeToDo(@PathVariable Long id){
        ToDoDto completedToDo = toDoService.completeToDo(id);
        return new ResponseEntity<>(completedToDo, HttpStatus.OK);
    }

    // [PATCH]: build inComplete ToDo Entity REST API
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<ToDoDto> inCompleteToDo(@PathVariable Long id){
        ToDoDto inCompletedToDo = toDoService.inCompleteToDo(id);
        return new ResponseEntity<>(inCompletedToDo, HttpStatus.OK);
    }

}
