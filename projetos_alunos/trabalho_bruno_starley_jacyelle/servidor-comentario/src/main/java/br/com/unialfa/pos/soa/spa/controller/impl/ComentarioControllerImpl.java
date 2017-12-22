package br.com.unialfa.pos.soa.spa.controller.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unialfa.pos.soa.spa.controller.ComentarioController;
import br.com.unialfa.pos.soa.spa.core.model.entity.Comentario;
import br.com.unialfa.pos.soa.spa.core.to.Resultado;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;

@Controller
public class ComentarioControllerImpl implements ComentarioController {

	@Autowired
	ComentarioService comentarioService;

	@Override
	public String helloProfessorJuliano() throws JsonProcessingException {
		return "Hello Professor Juliano!";
	}

	@Override
	public String listaTodosOsComentarios() throws JsonProcessingException {
		List<Comentario> comentarios;

		try {
			comentarios = this.comentarioService.obtemTodosOsComentarios();
		} catch (Exception e) {
			e.printStackTrace();
			comentarios = new ArrayList<Comentario>();
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(comentarios);

		return jsonString;
	}

	@Override
	public String getComentario(@PathVariable("id") Long id) throws JsonProcessingException {
		Comentario comentario;

		try {
			comentario = this.comentarioService.obtemUmComentarioPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
			comentario = new Comentario();
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(comentario);

		return jsonString;
	}

	@Override
	public String addComentario(@PathVariable("tarefaId") Long tarefaId, @PathVariable("autorId") Long autorId,
			@PathVariable("corpo") String corpo) throws JsonProcessingException {
		return addUpdateComentario(null, tarefaId, autorId, corpo);
	}

	@Override
	public String updateComentario(@PathVariable("id") Long id, @PathVariable("tarefaId") Long tarefaId,
			@PathVariable("autorId") Long autorId, @PathVariable("corpo") String corpo) throws JsonProcessingException {
		return addUpdateComentario(id, tarefaId, autorId, corpo);
	}

	private String addUpdateComentario(Long id, Long tarefaId, Long autorId, String corpo) throws JsonProcessingException {
		Resultado resultado = new Resultado();

		try {
			Comentario comentario = new Comentario();
			comentario.setId(id);
			comentario.setTarefaId(tarefaId);
			comentario.setAutorId(autorId);
			comentario.setCorpo(URLDecoder.decode(corpo, "UTF-8"));
			comentario.setData(new Date());

			this.comentarioService.gravaComentario(comentario);
			resultado.setSucesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setSucesso(false);
			resultado.setMensagem(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(resultado);

		return jsonString;
	}

	@Override
	public String deleteComentario(@PathVariable("id") Long id) throws JsonProcessingException {
		Resultado resultado = new Resultado();

		try {
			this.comentarioService.removeComentario(id);
			resultado.setSucesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setSucesso(false);
			resultado.setMensagem(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(resultado);

		return jsonString;
	}

	@Override
	public String deleteTodosComentariosDaTarefa(@PathVariable("id") Long id) throws JsonProcessingException {
		Resultado resultado = new Resultado();

		try {
			List<Comentario> comentarios = this.comentarioService.obtemTodosOsComentariosDaTarefa(id);
			for (Comentario comentario : comentarios) {
				this.comentarioService.removeComentario(comentario.getId());
			}
			resultado.setSucesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setSucesso(false);
			resultado.setMensagem(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(resultado);

		return jsonString;
	}

	@Override
	public String deleteTodosComentariosDoAutor(@PathVariable("id") Long id) throws JsonProcessingException {
		Resultado resultado = new Resultado();

		try {
			List<Comentario> comentarios = this.comentarioService.obtemTodosOsComentariosDoAutor(id);
			for (Comentario comentario : comentarios) {
				this.comentarioService.removeComentario(comentario.getId());
			}
			resultado.setSucesso(true);
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setSucesso(false);
			resultado.setMensagem(e.getMessage());
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(resultado);

		return jsonString;
	}

}
