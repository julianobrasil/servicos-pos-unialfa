package br.com.unialfa.pos.soa.rest.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.unialfa.pos.soa.rest.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.rest.core.model.entity.UsuarioTarefa;

@RequestMapping("/usuarios-tarefas")
public interface UsuarioTarefaController {

	@GetMapping("/find-by-tarefa-id/{idTarefa}")
	public ResponseEntity<Page<UsuarioTarefa>> getAll(@PathVariable Long idTarefa, Pageable pageable);
	
	@PostMapping("/save-or-create")
	public ResponseEntity<UsuarioTarefa> saveOrUpdate(@RequestBody UsuarioTarefa usuarioTarefa);
	
	
	@RequestMapping(value="/remove/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> remove(@PathVariable Long id);
	
	@GetMapping("/usuarios-por-tarefaId/{idTarefa}")
	public ResponseEntity<List<Usuario>> getUsuariosPorTarefa(Long idTarefa);
}
