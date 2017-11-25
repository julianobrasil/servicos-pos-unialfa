package br.com.unialfa.pos.monolitico.core.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unialfa.pos.monolitico.core.model.entity.UsuarioTarefa;

public interface UsuarioTarefaRepository extends JpaRepository<UsuarioTarefa,Long> {

	List<UsuarioTarefa> findByTarefaIdOrderByUsuarioNome(Long idTarefaSelecionada);

	List<UsuarioTarefa> findByUsuarioId(Long id);

	List<UsuarioTarefa> findByTarefaId(Long id);

}
