package com.example.livro.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.livro.entities.Message;



@Controller
public class WebSocketController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleMessage(Message message) {
        // Processar a mensagem e retornar uma resposta
        return new Message("Servidor", "Recebido: " + message.getContent() +
        " Obrigado por conversar comigo :-)" );
    }
}
