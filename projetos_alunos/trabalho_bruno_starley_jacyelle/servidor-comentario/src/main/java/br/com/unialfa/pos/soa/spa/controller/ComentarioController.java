package br.com.unialfa.pos.soa.spa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ComentarioController {

	@ResponseBody
	@GetMapping("/")
	public String helloProfessorJuliano() throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/list-all")
	public String listaTodosOsComentarios() throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/get/{id}")
	public String getComentario(@PathVariable("id") Long id) throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/add/{tarefaId}/{autorId}/{corpo}")
	public String addComentario(@PathVariable("tarefaId") Long tarefaId, @PathVariable("autorId") Long autorId,
			@PathVariable("corpo") String corpo) throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/update/{id}/{tarefaId}/{autorId}/{corpo}")
	public String updateComentario(@PathVariable("id") Long id, @PathVariable("tarefaId") Long tarefaId,
			@PathVariable("autorId") Long autorId, @PathVariable("corpo") String corpo) throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/delete/{id}")
	public String deleteComentario(@PathVariable("id") Long id) throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/delete-all-by-tarefa/{id}")
	public String deleteTodosComentariosDaTarefa(@PathVariable("id") Long id) throws JsonProcessingException;

	@ResponseBody
	@GetMapping("/comentario/delete-all-by-autor/{id}")
	public String deleteTodosComentariosDoAutor(@PathVariable("id") Long id) throws JsonProcessingException;

}
