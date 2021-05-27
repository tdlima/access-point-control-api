package com.lima.accesspoint.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banco_horas")
public class BanckHours {
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class BanckHoursId implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private Long idBanckHours;		
		private Long idPointMarking;		
		private Long idUser;		
	}
	
	@EmbeddedId
	@JoinColumn(name = "banco_horas_id")
	private BanckHoursId banckHoursId;
		
	@Column(name = "saldo_horas_trabalhadas")
	private BigDecimal balanceWorkedHours;
}
