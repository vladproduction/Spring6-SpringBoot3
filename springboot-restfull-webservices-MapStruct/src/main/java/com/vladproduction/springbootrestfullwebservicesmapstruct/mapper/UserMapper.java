package com.vladproduction.springbootrestfullwebservicesmapstruct.mapper;


import com.vladproduction.springbootrestfullwebservicesmapstruct.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesmapstruct.entity.User;

public class UserMapper {

    //convert User JPA Entity into UserDto
    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    //convert UserDto into User JPA Entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }

}
