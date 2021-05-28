package com.lima.accesspoint.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class CollaboratorRspDTO {
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String phone;

	private CompanyRspDTO company;

	private RoleRspDTO role;

	private WorkdayRspDTO workday;
	
	private String entrance;
	
	private String wayOut;
	
	private String tolerance;
	
	private List<CollaboratorAddressRspDTO> address;

}