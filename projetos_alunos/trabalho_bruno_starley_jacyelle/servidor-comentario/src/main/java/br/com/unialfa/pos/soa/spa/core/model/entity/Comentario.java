package br.com.unialfa.pos.soa.spa.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "comentario")
@Data
@EqualsAndHashCode(callSuper = false)
public class Comentario extends AbstractEntity {

	@JsonProperty
	@Column(nullable = false)
	private String corpo;

	@JsonProperty
	@Column(nullable = false)
	private Date data;

	@JsonProperty
	@Column(nullable = false)
	private Long autorId;

	@JsonProperty
	@Column(nullable = false)
	private Long tarefaId;

}
