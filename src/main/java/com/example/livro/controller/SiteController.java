package com.example.livro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.livro.validation.PaginaNaoEncontrada;

@Controller

public class SiteController{
    @GetMapping("/")
    public String index(){
      return "websocket";
    }

   
}

