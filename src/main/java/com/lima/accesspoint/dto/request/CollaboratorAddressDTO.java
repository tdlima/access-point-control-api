package com.lima.accesspoint.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorAddressDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 5, max = 80)
	private String address;
	
	@NotEmpty
	@Size(min = 4, max = 30)
	private String district;
	
	@NotEmpty
	@Size(min = 3, max = 20)
	private String city;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cep;

}
