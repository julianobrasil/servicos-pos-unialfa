package br.com.unialfa.pos.soa.rest.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;

@RequestMapping("tarefas")
public interface TarefaController {

	@GetMapping("/all")
	public ResponseEntity<Page<Tarefa>> getAll( Pageable pageable);
	
	@PostMapping("/save-or-create")
	public ResponseEntity<Tarefa> salvarOrUpdate(@RequestBody Tarefa tarefa, BindingResult result);

	@RequestMapping(value="/remove/{id}",method=RequestMethod.DELETE )
	public ResponseEntity<Void> remover(@PathVariable Long id);
}
