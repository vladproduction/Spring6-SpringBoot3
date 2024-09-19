package com.vladproduction.spring.core.demoapp;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    public String hello(){
        return "Hello repository";
    }

}
