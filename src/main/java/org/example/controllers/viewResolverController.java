package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class viewResolverController {

    @GetMapping("/home")
    public String home(){
        return "/main/home";
    }
}
