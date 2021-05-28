package com.lima.accesspoint.dto.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
	
	private Long id;
	
	@Size(min = 10, max = 80)
	@NotEmpty
	private String description;
	
	@Size(min = 18, max = 18)
	@NotEmpty
	private String cnpj;
	
	@NotEmpty
	@Valid
	private List<CompanyAddressDTO> companyAddress;
	
	@Size(min = 10, max = 11)
	@NotEmpty
	private String phone;	

}
