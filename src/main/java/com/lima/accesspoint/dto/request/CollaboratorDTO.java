package com.lima.accesspoint.dto.request;

import java.math.BigDecimal;
import java.util.List;

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
	
	@Size(min = 3, max = 80)
	private String name;
	
	@CPF
	private String cpf;

	@Size(min = 10, max = 11)
	private String phone;

	private CollaboratorRoleDTO collaboratorRole;

	private CompanyDTO company;
	
	private List<CollaboratorAddressDTO> collaboratorAddress;
	
	private WorkdayDTO workday;
	
	private BigDecimal tolerance;
	
	private BigDecimal entrance;
	
	private BigDecimal wayOut;

}





