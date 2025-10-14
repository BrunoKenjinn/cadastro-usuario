package com.java.aula.cadastro_filmes.infrastructure.repository;

import com.java.aula.cadastro_filmes.infrastructure.entitys.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    List<Filme> findByNomeContainingIgnoreCase(String nome);
}
