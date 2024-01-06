package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class securityController {

    @GetMapping("/home")
    public String rehome()
    {
        return "redirect:/home";
    }

    @GetMapping("/errorPage")
    public String erroPage()
    {
        return "errorpage";
    }
}
