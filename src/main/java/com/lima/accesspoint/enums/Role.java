package com.lima.accesspoint.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
	
	ADMINISTRATIVO("Administrativo"),
	FINANCEIRO("Financeiro"),
	SUPERVISÃO("Supervisão"),
	MANUTENCAO("Manutenção"),
	RH("RH"),
	SERVICOS_GERAIS("Serviços Gerais");
	
	private String description;

}
