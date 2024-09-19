package com.vladproduction.spring.core.demoapp;

import org.springframework.stereotype.Controller;

@Controller
public class DemoController {

    public String hello(){
        return "Hello controller";
    }

}
