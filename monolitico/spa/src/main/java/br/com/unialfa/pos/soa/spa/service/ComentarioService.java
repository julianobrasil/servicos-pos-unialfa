package br.com.unialfa.pos.soa.spa.service;

import java.util.List;

import br.com.unialfa.pos.soa.spa.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioTo;

public interface ComentarioService {
	List<Comentario> obtemTodosOsComentarios();
	
	Comentario gravaComentario(ComentarioTo comentario) throws Exception;

	void removeComentario(Long id);

	Comentario obtemComentarioPorId(Long id);

}
