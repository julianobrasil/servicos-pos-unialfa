package br.com.unialfa.pos.soa.spa.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.unialfa.pos.soa.spa.controller.ControllerPrincipal;
import br.com.unialfa.pos.soa.spa.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.spa.core.model.entity.Usuario;
import br.com.unialfa.pos.soa.spa.core.model.entity.UsuarioTarefa;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioCompleto;
import br.com.unialfa.pos.soa.spa.core.to.ComentarioTo;
import br.com.unialfa.pos.soa.spa.core.to.UsuarioTarefaTo;
import br.com.unialfa.pos.soa.spa.helper.Constante;
import br.com.unialfa.pos.soa.spa.service.ComentarioService;
import br.com.unialfa.pos.soa.spa.service.TarefaService;
import br.com.unialfa.pos.soa.spa.service.UsuarioService;

@Controller
public class ControllerPrincipalImpl implements ControllerPrincipal {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TarefaService tarefaService;
	
	@Autowired
	ComentarioService comentarioService;
	
	String destino = Constante.USUARIOS;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	private void carregaObjetosDaTela(ModelAndView mv, Boolean limpaForms) {

		if (limpaForms) {
			mv.addObject("usuario", new Usuario());
			mv.addObject("tarefa", new Tarefa());
			mv.addObject("usuarioTarefa", new UsuarioTarefaTo());
			mv.addObject("comentario", new ComentarioTo());
		}

		List<Usuario> users = this.usuarioService.obtemTodosOsUsuarios();
		mv.addObject("usuarios", users);

		List<Tarefa> tasks = this.tarefaService.obtemTodasAsTarefas();
		mv.addObject("tarefas", tasks);

		List<ComentarioCompleto> comentarios = this.comentarioService.obtemTodosOsComentarios();
		mv.addObject("comentarios", comentarios);

	}

	private void carregaObjetosDaTela(ModelAndView mv, Boolean limpaForms, Long idTarefaSelecionada) {

		if (limpaForms) {
			mv.addObject("usuario", new Usuario());
			mv.addObject("tarefa", new Tarefa());
			mv.addObject("usuarioTarefa", new UsuarioTarefaTo());
			mv.addObject("comentario", new ComentarioTo());
		}

		List<Usuario> users = this.usuarioService.obtemTodosOsUsuarios();
		mv.addObject("usuarios", users);

		List<Tarefa> tasks = this.tarefaService.obtemTodasAsTarefas();
		mv.addObject("tarefas", tasks);

		if (idTarefaSelecionada != null) {
			List<UsuarioTarefa> uts = this.tarefaService.obtemTodasAsAlocacoes(idTarefaSelecionada);
			mv.addObject("usuariosTarefas", uts);
		}

		List<ComentarioCompleto> comentarios = this.comentarioService.obtemTodosOsComentarios();
		mv.addObject("comentarios", comentarios);
	}

	@Override
	public ModelAndView spa(Model model) {
		ModelAndView mv = new ModelAndView("spa");

		this.carregaObjetosDaTela(mv, true);

		mv.addObject("abaAtiva", this.destino);

		return mv;
	}

	@Override
	public String spaAddUser(@ModelAttribute Usuario usuario) {

		try {
			this.usuarioService.gravaUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.destino = Constante.USUARIOS;

		return "redirect:/spa";
	}

	@Override
	public String spaDeleteUser(@PathVariable("id") Long id) {
		this.usuarioService.removeUsuario(id);
		
		this.destino = Constante.USUARIOS;

		return "redirect:/spa";
	}

	@Override
	public ModelAndView spaEditUser(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("spa");

		Usuario usuario = this.usuarioService.obtemUsuarioPorId(id);
		mv.addObject("usuario", usuario);

		mv.addObject("tarefa", new Tarefa());
		
		mv.addObject("usuarioTarefa", new UsuarioTarefaTo());
		
		mv.addObject("comentario", new ComentarioTo());

		this.carregaObjetosDaTela(mv, false);

		mv.addObject("abaAtiva", Constante.USUARIOS);

		return mv;
	}

	@Override
	public String spaAddTarefa(@ModelAttribute Tarefa tarefa) {
		try {
			this.tarefaService.gravaTarefa(tarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.destino = Constante.TAREFAS;

		return "redirect:/spa";
	}

	@Override
	public String spaDeleteTarefa(@PathVariable("id") Long id) {
		try {
			this.tarefaService.removeTarefa(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.destino = Constante.TAREFAS;

		return "redirect:/spa";
	}

	@Override
	public ModelAndView spaEditTarefa(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("spa");

		Tarefa tarefa = this.tarefaService.obtemTarefaPorId(id);
		mv.addObject("tarefa", tarefa);

		mv.addObject("usuario", new Usuario());

		mv.addObject("usuarioTarefa", new UsuarioTarefaTo());
		
		mv.addObject("comentario", new ComentarioTo());

		this.carregaObjetosDaTela(mv, false);

		mv.addObject("abaAtiva", Constante.TAREFAS);

		return mv;
	}

	@Override
	public ModelAndView spaAlocaTarefa(@ModelAttribute UsuarioTarefaTo usuarioTarefa) {
		ModelAndView mv = new ModelAndView("spa");
		UsuarioTarefa ut = null;
		try {
			ut = this.tarefaService.alocaTarefa(usuarioTarefa);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregaObjetosDaTela(mv, true, ut.getTarefa().getId());

		UsuarioTarefaTo to = new UsuarioTarefaTo();
		to.setIdTarefa(ut.getTarefa().getId());
		mv.addObject("usuarioTarefa", to);

		mv.addObject("abaAtiva", Constante.TAREFAS_ALOCADAS);
		
		this.destino = Constante.TAREFAS_ALOCADAS;

		return mv;
	}

	@Override
	public ModelAndView spaDesalocaTarefa(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("spa");
		UsuarioTarefa ut = null;
		try {
			ut = this.tarefaService.desalocaTarefa(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.carregaObjetosDaTela(mv, true, ut.getTarefa().getId());

		UsuarioTarefaTo to = new UsuarioTarefaTo();
		to.setIdTarefa(ut.getTarefa().getId());
		mv.addObject("usuarioTarefa", to);

		mv.addObject("abaAtiva", Constante.TAREFAS_ALOCADAS);
		
		this.destino = Constante.TAREFAS_ALOCADAS;

		return mv;
	}

	@Override
	public ModelAndView spaObtemUsuarioDaTarefaTarefa(@PathVariable("id") Long idTarefa) {
		ModelAndView mv = new ModelAndView("spa");

		this.carregaObjetosDaTela(mv, true, idTarefa);

		UsuarioTarefaTo to = new UsuarioTarefaTo();
		to.setIdTarefa(idTarefa);
		mv.addObject("usuarioTarefa", to);
		mv.addObject("abaAtiva", Constante.TAREFAS_ALOCADAS);
		
		this.destino = Constante.TAREFAS_ALOCADAS;

		return mv;
	}

	@Override
	public String spaAddComentario(@ModelAttribute ComentarioTo comentario) {
		try {
			this.comentarioService.gravaComentario(comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.destino = Constante.COMENTARIOS;

		return "redirect:/spa";
	}

	@Override
	public String spaDeleteComentario(@PathVariable("id") Long id) {
		try {
			this.comentarioService.removeComentario(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.destino = Constante.COMENTARIOS;

		return "redirect:/spa";
	}

	@Override
	public ModelAndView spaEditComentario(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("spa");

		mv.addObject("tarefa", new Tarefa());

		mv.addObject("usuario", new Usuario());

		mv.addObject("usuarioTarefa", new UsuarioTarefaTo());
		
		ComentarioCompleto comentario = this.comentarioService.obtemComentarioPorId(id);
		ComentarioTo comentarioTo = new ComentarioTo();
		comentarioTo.setId(comentario.getId());
		comentarioTo.setCorpo(comentario.getCorpo());
		comentarioTo.setData(comentario.getData());
		comentarioTo.setAutorId(comentario.getAutor() != null ? comentario.getAutor().getId() : null);
		comentarioTo.setTarefaId(comentario.getTarefa() != null ? comentario.getTarefa().getId() : null);
		mv.addObject("comentario", comentarioTo);

		this.carregaObjetosDaTela(mv, false);

		mv.addObject("abaAtiva", Constante.COMENTARIOS);

		return mv;
	}

}
