package com.vladproduction.todomanagementsecuritydatabase.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("vladproduction: ");
        System.out.println(passwordEncoder.encode("vladproduction"));
        System.out.println("admin: ");
        System.out.println(passwordEncoder.encode("admin"));

    }
}
