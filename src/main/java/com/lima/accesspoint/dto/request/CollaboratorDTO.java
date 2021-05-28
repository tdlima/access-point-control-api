package com.lima.accesspoint.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 80)
	private String name;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	@Size(min = 10, max = 11)
	private String phone;
	
	private RoleDTO role;
	
	private CompanyDTO company;
	
	@Valid
	@NotEmpty
	private List<CollaboratorAddressDTO> address;
	
	private WorkdayDTO workday;
	
	@NotEmpty
	private String tolerance;
	
	@NotEmpty
	private String entrance;
	
	@NotEmpty
	private String wayOut;

}





