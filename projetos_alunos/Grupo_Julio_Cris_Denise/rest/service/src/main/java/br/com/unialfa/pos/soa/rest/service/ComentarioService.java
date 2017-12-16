package br.com.unialfa.pos.soa.rest.service;

import java.util.List;

import br.com.unialfa.pos.soa.rest.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;

public interface ComentarioService {

	public Comentario salvar(Comentario comentario );
	
	public List<Comentario> obterTodosComentariosPorTarefa(Tarefa tarefa);
	
	public void removerComentario(Long idComentario);
	

}
