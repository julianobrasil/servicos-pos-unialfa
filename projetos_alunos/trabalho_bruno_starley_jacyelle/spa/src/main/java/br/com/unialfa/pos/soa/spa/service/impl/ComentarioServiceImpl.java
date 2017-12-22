package br.com.unialfa.pos.soa.spa.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unialfa.pos.soa.spa.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.spa.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.spa.core.model.repository.TarefaRepository;
import br.com.unialfa.pos.soa.spa.core.model.repository.UsuarioRepository;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioCompleto;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioTo;
import br.com.unialfa.pos.soa.spa.core.to.Resultado;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;
import br.com.unialfa.pos.soa.spa.service.ComunicacaoHttpService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	String HTTP_ADRESS_SERVIDOR_COMENTARIO = "http://localhost:9000/comentario";

	@Autowired
	ComunicacaoHttpService comunicacaoHttpService;

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<ComentarioCompleto> obtemTodosOsComentarios() {
		List<ComentarioCompleto> comentarios = new ArrayList<ComentarioCompleto>();

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO + "/list-all";
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			ComentarioTo[] comentariosTo = mapper.readValue(jsonString, ComentarioTo[].class);

			for (ComentarioTo comentarioTo : comentariosTo) {
				ComentarioCompleto comentarioCompleto = converteComentarioToEmComentarioCompleto(comentarioTo);
				comentarios.add(comentarioCompleto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarios;
	}

	@Override
	public ComentarioCompleto obtemComentarioPorId(Long id) {
		ComentarioCompleto comentarioCompleto = null;

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO + "/get/" + id;
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			ComentarioTo comentarioTo = mapper.readValue(jsonString, ComentarioTo.class);
			comentarioCompleto = converteComentarioToEmComentarioCompleto(comentarioTo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comentarioCompleto;
	}

	private ComentarioCompleto converteComentarioToEmComentarioCompleto(ComentarioTo comentarioTo) {
		ComentarioCompleto comentarioCompleto = new ComentarioCompleto();

		comentarioCompleto.setId(comentarioTo.getId());
		comentarioCompleto.setCorpo(comentarioTo.getCorpo());
		comentarioCompleto.setData(comentarioTo.getData());

		Tarefa tarefa = this.tarefaRepository.findOne(comentarioTo.getTarefaId());
		comentarioCompleto.setTarefa(tarefa);

		Usuario usuario = this.usuarioRepository.findOne(comentarioTo.getAutorId());
		comentarioCompleto.setAutor(usuario);

		return comentarioCompleto;
	}

	@Override
	public boolean gravaComentario(ComentarioTo comentarioTo) {
		boolean sucesso = false;

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO;
			if (comentarioTo.getId() == null) {
				urlGet = urlGet + "/add/";
			} else {
				urlGet = urlGet + "/update/" + comentarioTo.getId() + "/";
			}
			urlGet = urlGet + comentarioTo.getTarefaId() + "/" + comentarioTo.getAutorId() + "/"
					+ URLEncoder.encode(comentarioTo.getCorpo(), "UTF-8");
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			Resultado resultado = mapper.readValue(jsonString, Resultado.class);

			System.out.println("(" + urlGet + ") sucesso:" + resultado.isSucesso());
			System.out.println("(" + urlGet + ") mensagem:" + resultado.getMensagem());

			sucesso = resultado.isSucesso();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucesso;
	}

	@Override
	@Transactional
	public boolean removeComentario(Long id) {
		boolean sucesso = false;

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO + "/delete/" + id;
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			Resultado resultado = mapper.readValue(jsonString, Resultado.class);

			System.out.println("(" + urlGet + ") sucesso:" + resultado.isSucesso());
			System.out.println("(" + urlGet + ") mensagem:" + resultado.getMensagem());

			sucesso = resultado.isSucesso();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucesso;
	}

	@Override
	public boolean removeTodosComentariosDaTarefa(Long id) {
		boolean sucesso = false;

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO + "/delete-all-by-tarefa/" + id;
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			Resultado resultado = mapper.readValue(jsonString, Resultado.class);

			System.out.println("(" + urlGet + ") sucesso:" + resultado.isSucesso());
			System.out.println("(" + urlGet + ") mensagem:" + resultado.getMensagem());

			sucesso = resultado.isSucesso();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucesso;
	}

	@Override
	public boolean removeTodosComentariosDoAutor(Long id) {
		boolean sucesso = false;

		try {
			String urlGet = HTTP_ADRESS_SERVIDOR_COMENTARIO + "/delete-all-by-autor/" + id;
			String jsonString = comunicacaoHttpService.executeGet(urlGet);

			ObjectMapper mapper = new ObjectMapper();
			Resultado resultado = mapper.readValue(jsonString, Resultado.class);

			System.out.println("(" + urlGet + ") sucesso:" + resultado.isSucesso());
			System.out.println("(" + urlGet + ") mensagem:" + resultado.getMensagem());

			sucesso = resultado.isSucesso();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucesso;
	}

}
