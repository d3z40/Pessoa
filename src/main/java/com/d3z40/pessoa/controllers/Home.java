package com.d3z40.pessoa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Home {

    @GetMapping(value = "/")
    public String getMsg() {
        return "Estamos Online com o REST!!!";
    }
}
