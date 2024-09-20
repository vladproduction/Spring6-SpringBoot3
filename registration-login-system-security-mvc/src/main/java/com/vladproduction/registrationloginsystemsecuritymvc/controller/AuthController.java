package com.vladproduction.registrationloginsystemsecuritymvc.controller;

import com.vladproduction.registrationloginsystemsecuritymvc.dto.UserDtoFullName;
import com.vladproduction.registrationloginsystemsecuritymvc.entity.User;
import com.vladproduction.registrationloginsystemsecuritymvc.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handle home page request
    // http://localhost:8080/index
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handle registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        //model object to store form data
        UserDtoFullName user = new UserDtoFullName();
        model.addAttribute("user", user);

        return "register";
    }

    // handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDtoFullName user,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "This email already registered");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }
        userService.saveUserDtoFullName(user);
        return "redirect:/register?success";
    }

    //handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDtoFullName> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

}
