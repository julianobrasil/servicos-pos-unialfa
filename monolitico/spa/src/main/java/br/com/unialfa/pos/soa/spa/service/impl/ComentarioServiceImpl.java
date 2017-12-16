package br.com.unialfa.pos.soa.spa.service.impl;

import br.com.unialfa.pos.soa.spa.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.spa.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.spa.core.model.entity.Usuario;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unialfa.pos.soa.spa.core.model.repository.ComentarioRepository;
import br.com.unialfa.pos.soa.spa.core.model.repository.TarefaRepository;
import br.com.unialfa.pos.soa.spa.core.model.repository.UsuarioRepository;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioTo;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ComentarioRepository comentarioRepository;

	@Override
	public List<Comentario> obtemTodosOsComentarios() {

		List<Comentario> comentarios = this.comentarioRepository.findByOrderByDataDesc();

		return comentarios;

	}
	
	@Override
	public Comentario gravaComentario(ComentarioTo comentarioTo) {
		
		Comentario comentario = new Comentario();

		Usuario usuario = this.usuarioRepository.findOne(comentarioTo.getIdAutor());

		Tarefa tarefa = this.tarefaRepository.findOne(comentarioTo.getIdTarefa());

		comentario.setId(comentarioTo.getId());
		comentario.setCorpo(comentarioTo.getCorpo());
		comentario.setData(new Date());
		comentario.setTarefa(tarefa);
		comentario.setAutor(usuario);

		comentario = this.comentarioRepository.save(comentario);

		return comentario;
	}

	@Override
	@Transactional
	public void removeComentario(Long id) {
		this.comentarioRepository.delete(id);
	}

	@Override
	public Comentario obtemComentarioPorId(Long id) {
		Comentario comentario = this.comentarioRepository.findOne(id);
		return comentario;
	}

}
