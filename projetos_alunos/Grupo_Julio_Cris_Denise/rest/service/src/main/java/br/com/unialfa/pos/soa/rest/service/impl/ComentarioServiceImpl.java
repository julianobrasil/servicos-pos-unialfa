package br.com.unialfa.pos.soa.rest.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unialfa.pos.soa.rest.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.rest.core.model.repository.ComentarioRepository;
import br.com.unialfa.pos.soa.rest.core.model.repository.TarefaRepository;
import br.com.unialfa.pos.soa.rest.core.model.repository.UsuarioRepository;
import br.com.unialfa.pos.soa.rest.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ComentarioRepository comentarioRepository;

	@Override
	public Comentario salvar(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

	@Override
	public List<Comentario> obterTodosComentariosPorTarefa(Tarefa tarefa) {
		return this.comentarioRepository.findByTarefaId(tarefa.getId());
		
	}

	@Override
	public void removerComentario(Long idComentario) {
		this.comentarioRepository.delete(idComentario);
		
	}

	
	
}
