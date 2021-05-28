package com.lima.accesspoint.dto.response;

import com.lima.accesspoint.enums.ContractType;

import lombok.Data;

@Data
public class WorkdayRspDTO {
	
	private String description;
	
	private ContractType contractType;

}
