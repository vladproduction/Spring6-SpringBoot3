package com.vladproduction.springscopes.eager;

import org.springframework.stereotype.Component;

@Component
public class EagerLoader {

    public EagerLoader() {
        System.out.println("EagerLoader constructor...");
    }
}
