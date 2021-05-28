package com.lima.accesspoint.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colaborador")
public class Collaborator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	private String cpf;
	
	@Column(name = "telefone")
	private String phone;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "endereco_colaborador_id")
	private List<CollaboratorAddress> address;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "cargo_usuario_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "jornada_trabalho_id")
	private Workday workday;
	
	@Column(name = "tolerancia")
	private String tolerance;
	
	@Column(name = "entrada")
	private String entrance;
	
	@Column(name = "saida")
	private String wayOut;
}
