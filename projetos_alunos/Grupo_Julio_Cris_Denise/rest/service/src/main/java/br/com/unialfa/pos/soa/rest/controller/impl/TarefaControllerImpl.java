package br.com.unialfa.pos.soa.rest.controller.impl;

import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unialfa.pos.soa.rest.controller.TarefaController;
import br.com.unialfa.pos.soa.rest.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.rest.service.TarefaService;

@RestController
public class TarefaControllerImpl implements TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@Override
	public ResponseEntity<Page<Tarefa>> getAll(Pageable pageable) {
		
		return new ResponseEntity<Page<Tarefa>>(tarefaService.obtemTodasAsTarefas(pageable),HttpStatus.OK);
	}

	
	@Override
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		tarefaService.removeTarefa(id);
		return new ResponseEntity(HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Tarefa> salvarOrUpdate(@RequestBody Tarefa tarefa, BindingResult result) {
		try {
			tarefa = tarefaService.gravaTarefa(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
	}

}
