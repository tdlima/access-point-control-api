package com.lima.accesspoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lima.accesspoint.enums.StateAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco_empresa")
public class CompanyAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "endereco")
	private String address;
	
	@Column(name = "bairro")
	private String district;
	
	@Column(name = "cidade")
	private String city;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private StateAddress stateAddress;
	
	private String cep;
}
