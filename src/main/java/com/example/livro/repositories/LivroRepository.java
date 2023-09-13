package com.example.livro.repositories;
import com.example.livro.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
