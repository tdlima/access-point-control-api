package com.lima.accesspoint.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marcacao_ponto")
public class PointMarking {
	
	@SuppressWarnings("serial")
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class PointMarkingId implements Serializable{
		
		private Long idPointMarking;
		private Long idCollaborator;
	}
	
	@EmbeddedId
	@Column(name = "ponto_marcacao_id")
	private PointMarkingId pointMarkingId;
	
	@Column(name = "entrada")
	private LocalDateTime entrance;
	
	@Column(name = "saida")
	private LocalDateTime way_Out;
	
	@Column(name = "horas_excedidas")
	private BigDecimal hoursExceeded;
	
	@Column(name = "horas_debito")
	private BigDecimal hoursDebited;

}
