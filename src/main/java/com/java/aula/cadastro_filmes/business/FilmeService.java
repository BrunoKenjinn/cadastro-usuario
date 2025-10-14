package com.java.aula.cadastro_filmes.business;

import com.java.aula.cadastro_filmes.infrastructure.entitys.Filme;
import com.java.aula.cadastro_filmes.infrastructure.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme salvarFilme(Filme filme) {
        return repository.save(filme);
    }

    public List<Filme> buscarTodos() {
        return repository.findAll();
    }

    public Filme buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public List<Filme> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public void deletarFilme(Integer id) {
        repository.deleteById(id);
    }

    public Filme atualizarFilme(Integer id, Filme filme) {
        Filme filmeEntity = buscarPorId(id);
        filmeEntity.setNome(filme.getNome());
        filmeEntity.setDiretor(filme.getDiretor());
        filmeEntity.setAnoLancamento(filme.getAnoLancamento());
        return repository.save(filmeEntity);
    }
}