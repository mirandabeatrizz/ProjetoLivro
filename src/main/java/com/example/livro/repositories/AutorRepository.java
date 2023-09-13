package com.example.livro.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.livro.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
