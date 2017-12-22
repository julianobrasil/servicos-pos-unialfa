package br.com.unialfa.pos.soa.spa.core.to;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unialfa.pos.soa.spa.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ComentarioTo extends AbstractEntity {
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private Long tarefaId;
	
	@JsonProperty
	private Long autorId;
	
	@JsonProperty
	private String corpo;
	
	@JsonProperty
	private Date data;
}
