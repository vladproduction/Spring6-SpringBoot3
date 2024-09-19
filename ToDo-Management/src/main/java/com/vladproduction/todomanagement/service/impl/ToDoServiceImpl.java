package com.vladproduction.todomanagement.service.impl;

import com.vladproduction.todomanagement.dto.ToDoDto;
import com.vladproduction.todomanagement.entity.ToDo;
import com.vladproduction.todomanagement.exception.ResourceNotFoundException;
import com.vladproduction.todomanagement.repository.ToDoRepository;
import com.vladproduction.todomanagement.service.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private ToDoRepository toDoRepository;

    private ModelMapper modelMapper;

    @Override
    public ToDoDto addToDo(ToDoDto toDoDto) {
        //convert Dto into Entity
        ToDo toDo = modelMapper.map(toDoDto, ToDo.class);
        //save Entity into DB
        ToDo savedToDo = toDoRepository.save(toDo);
        //convert Entity into Dto
        //return Dto
        return modelMapper.map(savedToDo, ToDoDto.class);
    }

    @Override
    public ToDoDto getToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        return modelMapper.map(toDo, ToDoDto.class);
    }

    @Override
    public List<ToDoDto> getAllToDos() {
        List<ToDo> todos = toDoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, ToDoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ToDoDto updateToDo(ToDoDto toDoDto, Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        toDo.setTitle(toDoDto.getTitle());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setCompleted(toDoDto.isCompleted());
        ToDo updatedToDo = toDoRepository.save(toDo);
        return modelMapper.map(updatedToDo, ToDoDto.class);
    }

    @Override
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        toDoRepository.deleteById(id);
    }

    @Override
    public ToDoDto completeToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        toDo.setCompleted(Boolean.TRUE);
        ToDo updatedToDo = toDoRepository.save(toDo);
        return modelMapper.map(updatedToDo, ToDoDto.class);
    }

    @Override
    public ToDoDto inCompleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        toDo.setCompleted(Boolean.FALSE);
        ToDo updatedToDo = toDoRepository.save(toDo);
        return modelMapper.map(updatedToDo, ToDoDto.class);
    }
}
