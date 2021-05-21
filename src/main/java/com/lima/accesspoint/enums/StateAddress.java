package com.lima.accesspoint.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StateAddress {
	
	MG("Minas Gerais"),
	SP("São Paulo"),
	RJ("Rio de Janeiro"),
	ES("Espirito Santo");
	
	
	private String description;

}
