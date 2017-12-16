package br.com.unialfa.pos.soa.rest.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unialfa.pos.soa.rest.core.model.entity.Comentario;

@RequestMapping("/comentarios")
public interface ComentarioController  {

	@GetMapping("/comentario-por-tarefa/{id}")
	public ResponseEntity<List<Comentario>> getAll(@PathVariable Long id);
	
	@PostMapping("/save-or-update")
	public ResponseEntity<Comentario> saveOrUpdate(@RequestBody Comentario comentario, BindingResult result);
	
	//@RequestMapping(value="/remove/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id);
	
	
}
