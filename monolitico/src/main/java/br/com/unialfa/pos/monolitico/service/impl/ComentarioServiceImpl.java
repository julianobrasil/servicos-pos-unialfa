package br.com.unialfa.pos.monolitico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unialfa.pos.monolitico.core.model.repository.ComentarioRepository;
import br.com.unialfa.pos.monolitico.core.model.repository.TarefaRepository;
import br.com.unialfa.pos.monolitico.core.model.repository.UsuarioRepository;
import br.com.unialfa.pos.monolitico.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ComentarioRepository comentarioRepository;

}
