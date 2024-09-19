package com.vladproduction.spring.core.demoapp;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String hello(){
        return "Hello service";
    }

}
