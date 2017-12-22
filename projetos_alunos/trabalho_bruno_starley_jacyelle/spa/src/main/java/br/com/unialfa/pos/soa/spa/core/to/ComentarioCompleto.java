package br.com.unialfa.pos.soa.spa.core.to;

import java.util.Date;

import br.com.unialfa.pos.soa.spa.core.model.entity.AbstractEntity;
import br.com.unialfa.pos.soa.spa.core.model.entity.Tarefa;
import br.com.unialfa.pos.soa.spa.core.model.entity.Usuario;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ComentarioCompleto extends AbstractEntity {
	private String corpo;
	private Date data;
	private Usuario autor;
	private Tarefa tarefa;
}
