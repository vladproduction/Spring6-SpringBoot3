package com.vladproduction.springbootstudentmanagementsystemwebmvc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    @NotEmpty(message = "Student First Name should not be empty")
    private String firstName;
    @NotEmpty(message = "Student Last Name should not be empty")
    private String lastName;
    @NotEmpty(message = "Student Email should not be empty")
    @Email
    private String email;


}
