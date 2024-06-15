package com.example.jwt.web;


import org.springframework.stereotype.Controller;

@Controller
public class SecurityController {

    public String login(){
        return "login";
    }
}
