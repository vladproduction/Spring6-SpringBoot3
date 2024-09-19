package com.vladproduction.springbootrestfullwebservicesmapstruct.mapper;

import com.vladproduction.springbootrestfullwebservicesmapstruct.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesmapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    //through this instance provides implementation methods of this interface at compile time
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

//    @Mapping(source = "email", target = "emailAddress") //in case different fields naming for user and userDto
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
