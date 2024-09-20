package com.vladproduction.thymeleafspringboot.controller;

import com.vladproduction.thymeleafspringboot.model.Avenger;
import com.vladproduction.thymeleafspringboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AvengerController {

    //handler method to handle list of models
    // http://localhost:8080/avengers
    @GetMapping("/avengers")
    public String avengers(Model model){
        Avenger ironman = new Avenger("Ironman", "intellect", "male", true);
        Avenger hulk = new Avenger("Hulk", "body-power", "male", true);
        Avenger spider_man = new Avenger("Spider-Man", "flexibility", "male", true);
        Avenger tor = new Avenger("Tor", "galactic-power", "male", true);
        Avenger wanda = new Avenger("Wanda", "control-insects", "female", true);

        List<Avenger> avengers = new ArrayList<>();
        avengers.add(ironman);
        avengers.add(hulk);
        avengers.add(spider_man);
        avengers.add(tor);
        avengers.add(wanda);

        model.addAttribute("avengers", avengers);

        return "avengers";
    }

    // http://localhost:8080/if-unless
    @GetMapping("/if-unless")
    public String ifUnless(Model model){
        Avenger ironman = new Avenger("Ironman", "intellect", "male", true);
        Avenger hulk = new Avenger("Hulk", "body-power", "male", false);
        Avenger spider_man = new Avenger("Spider-Man", "flexibility", "male", true);
        Avenger tor = new Avenger("Tor", "galactic-power", "male", false);
        Avenger wanda = new Avenger("Wanda", "control-insects", "female", true);
        List<Avenger> avengers = new ArrayList<>();
        avengers.add(ironman);
        avengers.add(hulk);
        avengers.add(spider_man);
        avengers.add(tor);
        avengers.add(wanda);
        model.addAttribute("avengers", avengers);
        return "if-unless";
    }

    // http://localhost:8080/switch-case
    @GetMapping("/switch-case")
    public String switchCase(Model model){
        Avenger avenger = new Avenger("Ironman", "intellect", "male", false);
        model.addAttribute("avenger", avenger);
        return "switch-case";
    }

}
