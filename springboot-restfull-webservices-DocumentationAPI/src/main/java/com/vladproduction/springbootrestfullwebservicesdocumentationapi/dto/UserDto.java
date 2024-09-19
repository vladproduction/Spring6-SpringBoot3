package com.vladproduction.springbootrestfullwebservicesdocumentationapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Schema(
            description = "User First Name"
    )
    //user firstName should not be null or empty
    @NotEmpty(message = "user firstName should not be null or empty")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    //user firstName should not be null or empty
    @NotEmpty(message = "user lastName should not be null or empty")
    private String lastName;

    @Schema(
            description = "User Email Address"
    )
    //user firstName should not be null or empty
    //Email should be valid
    @NotEmpty(message = "user email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;

}
