package com.vladproduction.springbootrestfullwebservicesdocumentationapi.controller;


import com.vladproduction.springbootrestfullwebservicesdocumentationapi.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesdocumentationapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST API: Create User, Get User, Get All Users, Update User, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "[POST]: create User REST API",
            description = "create User REST API is used for save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // [POST]: create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUser  = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "[GET]: get User by id REST API",
            description = "get User by Id REST API is used to select user from a database by Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: get User by id REST API
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId){
        UserDto userById = userService.getUserById(userId);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @Operation(
            summary = "[GET]: get all Users REST API",
            description = "get all Users REST API is used to select all users from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [GET]: get all Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "[PUT]: build update User REST API",
            description = "update User REST API is used for update particular user in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [PUT]: build update User REST API
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,
                                           @Valid @RequestBody UserDto userDto){
        userDto.setId(userId);
        UserDto updateUserDto = userService.updateUser(userDto);
        return new ResponseEntity<>(updateUserDto, HttpStatus.OK);
    }

    @Operation(
            summary = "[DELETE]: build delete User REST API",
            description = "delete User REST API is used for delete particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    // [DELETE]: build delete User REST API
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }


}
