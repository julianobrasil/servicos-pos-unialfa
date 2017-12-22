package br.com.unialfa.pos.soa.spa.core.to;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.unialfa.pos.soa.spa.core.model.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Resultado extends AbstractEntity {

	@JsonProperty
	private boolean sucesso;

	@JsonProperty
	private String mensagem;

}
