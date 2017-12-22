package br.com.unialfa.pos.soa.rest.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unialfa.pos.soa.rest.controller.ComentarioController;
import br.com.unialfa.pos.soa.rest.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.rest.service.ComentarioService;

@RestController
public class ComentarioControllerImpl implements ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@Override
	public ResponseEntity<List<Comentario>> getAll(@PathVariable Long id) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(id);
		return new ResponseEntity<List<Comentario>>(comentarioService.obterTodosComentariosPorTarefa(tarefa), HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<Comentario> saveOrUpdate(@RequestBody Comentario comentario, BindingResult result) {

		comentario = comentarioService.salvar(comentario);
		return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		comentarioService.removerComentario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
