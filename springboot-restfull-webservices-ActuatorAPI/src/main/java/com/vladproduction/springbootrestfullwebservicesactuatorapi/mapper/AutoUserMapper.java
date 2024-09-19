package com.vladproduction.springbootrestfullwebservicesactuatorapi.mapper;

import com.vladproduction.springbootrestfullwebservicesactuatorapi.dto.UserDto;
import com.vladproduction.springbootrestfullwebservicesactuatorapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    //through this instance provides implementation methods of this interface at compile time
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

//    @Mapping(source = "email", target = "emailAddress") //in case different fields naming for user and userDto
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
