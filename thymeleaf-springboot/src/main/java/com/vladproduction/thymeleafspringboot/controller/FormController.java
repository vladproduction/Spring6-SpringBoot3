package com.vladproduction.thymeleafspringboot.controller;

import com.vladproduction.thymeleafspringboot.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    //handler method to handle user registration page request
    // http://localhost:8080/register
    @GetMapping("register")
    public String userRegistrationPage(Model model){
        //empty UserForm to store form data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        List<Boolean> marriedStatus = Arrays.asList(true, false);
        model.addAttribute("marriedStatus", marriedStatus);

        List<String> listProfessions = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfessions", listProfessions);
        return "register-form";
    }

    //handler method to handle user registration form submission request
    @PostMapping("register/save")
    public String submitForm(Model model,
                             @ModelAttribute("userForm") UserForm userForm){
        model.addAttribute("userForm", userForm);
        return "register-success";

    }


}
