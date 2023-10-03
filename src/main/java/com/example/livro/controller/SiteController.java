package com.example.livro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.livro.validation.PaginaNaoEncontrada;

@Controller

public class SiteController{
    @GetMapping("/websocket")
    public String index(){
      return "websocket";
    }
     @GetMapping("/teste")
    public String teste(){
      return "teste";
    }

   
}

