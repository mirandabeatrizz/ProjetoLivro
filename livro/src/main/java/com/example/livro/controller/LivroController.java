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

import com.example.livro.entities.Livro;
import com.example.livro.repositories.LivroRepository;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/api/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    //criar
    @PostMapping("/adicionar")
    public Livro adicionarLivro(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }

    //atualizar
    @PutMapping("/atualizar/{id}") 
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro novoLivro){
        return livroRepository.findById(id).map(livro ->{
            livro.setTitulo(novoLivro.getTitulo());
            livro.setDescricao(novoLivro.getDescricao());
            livro.setIsbn(novoLivro.getIsbn());
            livro.setAnoPublicacao(novoLivro.getAnoPublicacao());
            livro.setCategoria(novoLivro.getCategoria());
            livro.setAutor(novoLivro.getAutor());
            return livroRepository.save(livro);
        })
        .orElseGet(() ->{
            throw new EntityNotFoundException(); //ta funcionando
        });
    }

    //mostrar
    @GetMapping("/listar")
    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    //buscar por id
    @GetMapping("/buscar/{id}")
    public Optional<Livro> buscarLivro(@PathVariable Long id){
         return livroRepository.findById(id);
        //throw new EntityNotFoundException();
    }

    //deletar
    @DeleteMapping("/excluir/{id}")
    public void excluirLivro(@PathVariable Long id){
        livroRepository.deleteById(id);
        throw new EntityNotFoundException();
    }

}
