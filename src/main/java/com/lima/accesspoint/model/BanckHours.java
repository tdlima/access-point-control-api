package com.lima.accesspoint.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "banco_horas")
public class BanckHours {
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class BanckHoursId implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private Long idBanckHours;		
		private Long idMovement;		
		private Long idUser;		
	}
	
	@EmbeddedId
	private BanckHoursId banckHoursId;
	
	@Column(name = "data_trabalhada")
	private LocalDateTime dateWorked;
	
	@Column(name = "horas_trabalhadas")
	private BigDecimal quantityWorkedHours;
	
	@Column(name = "saldo_horas_trabalhadas")
	private BigDecimal balanceWorkedHours;
}
