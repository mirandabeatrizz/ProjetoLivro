package com.example.livro.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.persistence.EntityNotFoundException;
import com.example.livro.validation.PaginaNaoEncontrada;

@ControllerAdvice
public class GlobalExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleGlobalException(EntityNotFoundException ex) {
        return new ResponseEntity<>("Código não encotrado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaginaNaoEncontrada.class)
    public ResponseEntity<String> handleResourceNotFoundException(PaginaNaoEncontrada ex) {
        return new ResponseEntity<>("Página não encontrada", HttpStatus.NOT_FOUND);
    }

}