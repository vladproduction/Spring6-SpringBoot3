package com.vladproduction.thymeleafspringboot.controller;

import com.vladproduction.thymeleafspringboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    //handler method to handle variable-expression request
    // http://localhost:8080/variable-expression
    @GetMapping("variable-expression")
    public String variableExpression(Model model){
        User user = new User("admin", "admin@gmail.com", "ADMIN", "male");
        model.addAttribute("user", user);
        return "variable-expression";
    }

    //handler method to handle selection-expression request
    // http://localhost:8080/selection-expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model){
        User tony = new User("Tony", "tony@gmail.com", "IRONMAN", "robot");
        model.addAttribute("tony", tony);
        return "selection-expression";
    }

    //handler method to handle message-expression request
    // http://localhost:8080/message-expression
    @GetMapping("message-expression")
    public String messageExpression(){

        return "message-expression";
    }

    //handler method to handle link-expression request
    // http://localhost:8080/link-expression
    @GetMapping("link-expression")
    public String linkExpression(Model model){
        model.addAttribute("id", 1);

        return "link-expression";
    }

    //handler method to handle fragment expression
    // http://localhost:8080/fragment-expression
    @GetMapping("fragment-expression")
    public String fragmentExpression(){

        return "fragment-expression";
    }


}
