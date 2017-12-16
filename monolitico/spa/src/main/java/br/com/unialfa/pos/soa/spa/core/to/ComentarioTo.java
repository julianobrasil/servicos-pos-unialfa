package br.com.unialfa.pos.soa.spa.core.to;

import java.util.Date;

import br.com.unialfa.pos.soa.spa.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ComentarioTo extends AbstractEntity {
	private Long id;
	private Long idTarefa;
	private Long idAutor;
	private String corpo;
	private Date data;
}
