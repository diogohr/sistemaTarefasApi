package com.diogo.sistematarefas.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.diogo.sistematarefas.model.Tarefa;
import com.diogo.sistematarefas.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {


    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }
    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
        return repository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(novaTarefa.getTitulo());
                    tarefa.setDescricao(novaTarefa.getDescricao());
                    tarefa.setConcluida(novaTarefa.isConcluida());
                    return repository.save(tarefa);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @GetMapping("/")
    public String home() {
        return "API Sistema de Tarefas está rodando ";
    }

}

