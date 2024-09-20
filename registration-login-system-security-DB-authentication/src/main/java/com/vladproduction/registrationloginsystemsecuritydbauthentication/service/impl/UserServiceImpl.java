package com.vladproduction.registrationloginsystemsecuritydbauthentication.service.impl;

import com.vladproduction.registrationloginsystemsecuritydbauthentication.dto.UserDto;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.entity.Role;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.entity.User;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.repository.RoleRepository;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.repository.UserRepository;
import com.vladproduction.registrationloginsystemsecuritydbauthentication.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // encrypting password by spring security
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

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDtoFullName(user))
                .collect(Collectors.toList());
    }
    /*@Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDtoFullName)
                .collect(Collectors.toList());
    }*/

    private UserDto mapToUserDtoFullName(User user){
        UserDto userDto = new UserDto();
        String [] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;

    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }
}
