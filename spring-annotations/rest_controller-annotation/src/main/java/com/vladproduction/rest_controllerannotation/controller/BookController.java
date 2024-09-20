package com.vladproduction.rest_controllerannotation.controller;

import com.vladproduction.rest_controllerannotation.beans.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class BookController {

    // http://localhost:8084/hello-world
    @RequestMapping("/hello-world")
//    @ResponseBody
    public String helleWorld(){
        return "Hello World!";
    }

    // http://localhost:8084/book
    @RequestMapping("/book")
//    @ResponseBody
    public Book getBook(){
       Book book = new Book(1, "Java Book", "Java Book overview");
       return book;
   }

}
