package com.vladproduction.registrationloginsystemsecuritymvc.service.impl;

import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDto;
import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDtoFullName;
import com.vladproduction.registrationloginsystemsecuritymvc.entity.Role;
import com.vladproduction.registrationloginsystemsecuritymvc.entity.User;
import com.vladproduction.registrationloginsystemsecuritymvc.repository.RoleRepository;
import com.vladproduction.registrationloginsystemsecuritymvc.repository.UserRepository;
import com.vladproduction.registrationloginsystemsecuritymvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(User user) {
        User userForSave = new User();
        userForSave.setName(user.getName());
        userForSave.setEmail(user.getEmail());
        userForSave.setPassword(user.getPassword());
        Role role = roleRepository.findByName("ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        userForSave.setRoles(Arrays.asList(role));
        userRepository.save(userForSave);

    }

    @Override
    public void saveUserByDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        Role role = roleRepository.findByName("ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public void saveUserDtoFullName(UserDtoFullName userDtoFullName) {
        User user = new User();
        user.setName(userDtoFullName.getFirstName() + " " + userDtoFullName.getLastName());
        user.setEmail(userDtoFullName.getEmail());
        user.setPassword(userDtoFullName.getPassword());
        Role role = roleRepository.findByName("ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /*@Override
    public List<UserDtoFullName> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDtoFullName(user))
                .collect(Collectors.toList());
    }*/
    @Override
    public List<UserDtoFullName> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDtoFullName)
                .collect(Collectors.toList());
    }

    private UserDtoFullName mapToUserDtoFullName(User user){
        UserDtoFullName userDtoFullName = new UserDtoFullName();
        String [] str = user.getName().split(" ");
        userDtoFullName.setFirstName(str[0]);
        userDtoFullName.setLastName(str[1]);
        userDtoFullName.setEmail(user.getEmail());
        return userDtoFullName;

    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }
}
