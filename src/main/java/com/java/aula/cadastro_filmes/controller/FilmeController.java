package com.java.aula.cadastro_filmes.controller;

import com.java.aula.cadastro_filmes.business.FilmeService;
import com.java.aula.cadastro_filmes.infrastructure.entitys.Filme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> salvarFilme(@RequestBody Filme filme) {
        return ResponseEntity.ok(filmeService.salvarFilme(filme));
    }

    @GetMapping
    public ResponseEntity<List<Filme>> buscarTodos() {
        return ResponseEntity.ok(filmeService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(filmeService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Filme>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(filmeService.buscarPorNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer id, @RequestBody Filme filme) {
        return ResponseEntity.ok(filmeService.atualizarFilme(id, filme));
    }
}