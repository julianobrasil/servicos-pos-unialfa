package br.com.unialfa.pos.soa.spa.service;

import java.util.List;

import br.com.unialfa.pos.soa.spa.core.to.ComentarioCompleto;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioTo;

public interface ComentarioService {
	
	List<ComentarioCompleto> obtemTodosOsComentarios();
	
	ComentarioCompleto obtemComentarioPorId(Long id);
	
	boolean gravaComentario(ComentarioTo comentario) throws Exception;

	boolean removeComentario(Long id);
	
	boolean removeTodosComentariosDaTarefa(Long id);
	
	boolean removeTodosComentariosDoAutor(Long id);

}
