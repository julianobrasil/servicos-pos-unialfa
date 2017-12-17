package br.com.unialfa.pos.soa.spa.service;

import java.util.List;

import br.com.unialfa.pos.soa.spa.core.model.entity.Comentario;

public interface ComentarioService {

	List<Comentario> obtemTodosOsComentarios();
	
	List<Comentario> obtemTodosOsComentariosDaTarefa(Long id);
	
	List<Comentario> obtemTodosOsComentariosDoAutor(Long id);

	Comentario obtemUmComentarioPorId(Long id);

	Comentario gravaComentario(Comentario comentario) throws Exception;

	void removeComentario(Long id);

}
