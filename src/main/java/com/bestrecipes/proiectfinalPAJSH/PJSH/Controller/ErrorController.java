package com.bestrecipes.proiectfinalPAJSH.PJSH.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class ErrorController {

    @GetMapping(path = "/error")
    public String error(String message){
        return "Try again";
    }
}



