package br.com.unialfa.pos.soa.spa.service.impl;

import br.com.unialfa.pos.soa.spa.core.model.entity.Comentario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unialfa.pos.soa.spa.core.model.repository.ComentarioRepository;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioRepository comentarioRepository;

	@Override
	public List<Comentario> obtemTodosOsComentarios() {
		List<Comentario> comentarios = this.comentarioRepository.findByOrderByDataDesc();
		return comentarios;
	}

	@Override
	public List<Comentario> obtemTodosOsComentariosDaTarefa(Long id) {
		List<Comentario> comentarios = this.comentarioRepository.findByTarefaId(id);
		return comentarios;
	}

	@Override
	public List<Comentario> obtemTodosOsComentariosDoAutor(Long id) {
		List<Comentario> comentarios = this.comentarioRepository.findByAutorId(id);
		return comentarios;
	}

	@Override
	public Comentario obtemUmComentarioPorId(Long id) {
		Comentario comentario = this.comentarioRepository.findOne(id);
		return comentario;
	}
	
	@Override
	@Transactional
	public Comentario gravaComentario(Comentario comentario) {
		comentario = this.comentarioRepository.save(comentario);
		return comentario;
	}

	@Override
	@Transactional
	public void removeComentario(Long id) {
		this.comentarioRepository.delete(id);
	}

}
