package br.com.unialfa.pos.soa.spa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unialfa.pos.soa.spa.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.spa.core.model.entity.UsuarioTarefa;
import br.com.unialfa.pos.soa.spa.core.model.repository.UsuarioRepository;
import br.com.unialfa.pos.soa.spa.core.model.repository.UsuarioTarefaRepository;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;
import br.com.unialfa.pos.soa.spa.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioTarefaRepository usuarioTarefaRepository;

	@Autowired
	ComentarioService comentarioService;

	@Override
	public List<Usuario> obtemTodosOsUsuarios() {
		List<Usuario> usuarios = this.usuarioRepository.findByOrderByNomeAsc();
		return usuarios;
	}

	@Override
	public Usuario gravaUsuario(Usuario usuario) {
		usuario = this.usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	@Transactional
	public void removeUsuario(Long id) {
		boolean sucesso = this.comentarioService.removeTodosComentariosDoAutor(id);
		if(!sucesso) {
			return;
		}
		
		List<UsuarioTarefa> uts = this.usuarioTarefaRepository.findByUsuarioId(id);
		this.usuarioTarefaRepository.delete(uts);

		this.usuarioRepository.delete(id);
	}

	@Override
	public Usuario obtemUsuarioPorId(Long id) {
		Usuario usuario = this.usuarioRepository.findOne(id);
		return usuario;
	}

}
