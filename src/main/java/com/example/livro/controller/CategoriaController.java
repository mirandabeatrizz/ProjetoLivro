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

import com.example.livro.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.livro.entities.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController{
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping ("/adicionar")
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/listar")
    public List<Categoria> listarcategoria() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Optional<Categoria> buscarProduto(@PathVariable Long id) {
        return categoriaRepository.findById(id);
        //throw new EntityNotFoundException();
    }

    @PutMapping("/editar/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNome(novaCategoria.getNome());
                    return categoriaRepository.save(categoria);
                })
                .orElseGet(() -> {
                    novaCategoria.setId(id);
                    return categoriaRepository.save(novaCategoria);
                });
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirProduto(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        throw new EntityNotFoundException();
    }

}
