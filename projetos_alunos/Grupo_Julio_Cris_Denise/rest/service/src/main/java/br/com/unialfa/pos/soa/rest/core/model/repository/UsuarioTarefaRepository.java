package br.com.unialfa.pos.soa.rest.core.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unialfa.pos.soa.rest.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.rest.core.model.entity.UsuarioTarefa;

public interface UsuarioTarefaRepository extends JpaRepository<UsuarioTarefa,Long> {

	Page<UsuarioTarefa> findByTarefaIdOrderByUsuarioNome(Long idTarefaSelecionada,Pageable pageable);

	List<UsuarioTarefa> findByUsuarioId(Long id);

	List<UsuarioTarefa> findByTarefaId(Long id);
	
	@Query("select u.usuario from UsuarioTarefa u where u.tarefa.id = :idTarefa")
	List<Usuario> findUsuariosByTarefaId(@Param("idTarefa") Long idTarefa);

}
