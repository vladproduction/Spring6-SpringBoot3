package com.vladproduction.springbootrestfullwebservicesvalidationapi.dto;


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
public class UserDto {

    private Long id;

    //user firstName should not be null or empty
    @NotEmpty(message = "user firstName should not be null or empty")
    private String firstName;

    //user firstName should not be null or empty
    @NotEmpty(message = "user lastName should not be null or empty")
    private String lastName;

    //user firstName should not be null or empty
    //Email should be valid
    @NotEmpty(message = "user email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

}
