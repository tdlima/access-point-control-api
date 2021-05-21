package com.lima.accesspoint.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "categoria_usuario_id")
	private UserCategory userCategory;
	
	@Column(name = "nome")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "nivel_acesso_id")
	private AccessLevel accessLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "jornada_trabalho_id")
	private Workday workday;
	
	@Column(name = "tolerancia")
	private BigDecimal tolerance;
	
	@Column(name = "inicio_jornada")
	private LocalDateTime startJourney;
	
	@Column(name = "final_jornada")
	private LocalDateTime finalJourney;
}
