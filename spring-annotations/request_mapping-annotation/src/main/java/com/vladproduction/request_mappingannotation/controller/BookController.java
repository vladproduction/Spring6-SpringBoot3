package com.vladproduction.request_mappingannotation.controller;

import com.vladproduction.request_mappingannotation.beans.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/api") //base url: 1)@RequestMapping with Class;
public class BookController {

    //2)@RequestMapping with Method;
    // http://localhost:8084/api/hello-world
    @RequestMapping("/hello-world")
    public String helleWorld(){
        return "Hello World!";
    }

    //3)@RequestMapping with Multiple URL:
    // http://localhost:8084/api/book
    // http://localhost:8084/api/java-core
//     http://localhost:8084/api/java
    @RequestMapping(value={"/book", "/java-core", "/java"},
        method = RequestMethod.GET,  //4)@RequestMapping with HTTP Method; (provides by default if not specifies as GET)
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} //5)@RequestMapping with Produces and Consumes;
    )
    public Book getBook(){
        Book book = new Book(1, "Java Book", "Java Book overview");
        return book;
    }

}
