package br.com.unialfa.pos.soa.rest.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	Page<Tarefa> findByOrderByDataInicioDesc(Pageable pageable);

}
