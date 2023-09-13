package com.example.livro.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livro.entities.Autor;
import com.example.livro.repositories.AutorRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/autor")
public class AutorController{
    @Autowired
    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @PostMapping("/adicionar")
    public Autor adicionarAutor(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }

    @PutMapping("/editar/{id}")
    public Autor editarAutor(@PathVariable Long id, @RequestBody Autor novoAutor){
        return autorRepository.findById(id).map(autor -> {
            autor.setNome(novoAutor.getNome());
            autor.setBiografia(novoAutor.getBiografia());
            autor.setDataNasc(novoAutor.getDataNasc());
            return autorRepository.save(autor);
        })
        .orElseGet(() ->{
            novoAutor.setId(id);
            return autorRepository.save(novoAutor);
        });
    }

    @GetMapping("/listar")
    public List<Autor> listarAutor(){
        return autorRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Autor> buscarAutor(@PathVariable Long id){
        return autorRepository.findById(id);
        //throw new EntityNotFoundException();
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirAutor(@PathVariable Long id){
        autorRepository.deleteById(id);
        throw new EntityNotFoundException();
    }

}