package com.diogo.sistematarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diogo.sistematarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
