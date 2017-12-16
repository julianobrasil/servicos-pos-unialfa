package br.com.unialfa.pos.soa.rest.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unialfa.pos.soa.rest.controller.UsuarioTarefaController;
import br.com.unialfa.pos.soa.rest.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.rest.core.model.entity.UsuarioTarefa;
import br.com.unialfa.pos.soa.rest.service.TarefaService;
import br.com.unialfa.pos.soa.rest.service.UsuarioService;

@RestController
public class UsuarioTarefaControllerImpl implements UsuarioTarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@Override
	public ResponseEntity<Page<UsuarioTarefa>> getAll(@PathVariable Long idTarefa, Pageable pageable) {
		
		return new ResponseEntity<Page<UsuarioTarefa>>(tarefaService.obtemTodasAsAlocacoes(idTarefa, pageable), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioTarefa> saveOrUpdate(@RequestBody UsuarioTarefa usuarioTarefa) {
		
		return new ResponseEntity<UsuarioTarefa>( tarefaService.alocaTarefa(usuarioTarefa), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		tarefaService.desalocaTarefa(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Usuario>> getUsuariosPorTarefa(@PathVariable Long idTarefa) {
		return new ResponseEntity<List<Usuario>>(tarefaService.listaUsuariosPorTarefa(idTarefa), HttpStatus.OK);
	}

}
