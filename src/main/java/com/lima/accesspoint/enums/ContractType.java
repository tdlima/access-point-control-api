package com.lima.accesspoint.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContractType {
	
	CLT("CLT"),
	PJ("PJ"),
	TERCEIRIZADO("Terceirizado"),
	ESTAGIARIO("Estagiario"),
	JOVEM_APRENDIZ("Jovem Aprendiz");
	
	private String description;

}
