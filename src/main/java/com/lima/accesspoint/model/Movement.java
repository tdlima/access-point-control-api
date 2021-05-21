package com.lima.accesspoint.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "movimentacao")
public class Movement {
	
	@SuppressWarnings("serial")
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class MovementId implements Serializable{
		
		private Long idMoviment;
		private Long idUser;
	}
	
	@EmbeddedId
	private MovementId movementId;
	
	@Column(name = "data_entrada")
	private LocalDateTime entranceDate;
	
	@Column(name = "data_saida")
	private LocalDateTime exitDate;
	
	@Column(name = "periodo")
	private BigDecimal period;
	
	@ManyToMany
	@Column(name = "ocorrencia_id")
	private List<Occurrence> ocurrence;
	
	@ManyToMany
	@Column(name = "calendario_id")
	private List<Calendar> calendar;
}
