package com.valid8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {


    @GetMapping("/")
    public String login() {
        return "login";
    }

    
    @GetMapping("/student")
    public String student() {
        return "student";
    }

   
    @GetMapping("/rupd")
    public String rupd() {
        return "rupd";
    }



    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/violations")
    public String violations() {
        return "violations";
    }

    @GetMapping("/unregistered")
    public String unregistered() {
        return "unregistered";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}
