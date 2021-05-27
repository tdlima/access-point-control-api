package com.lima.accesspoint.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lima.accesspoint.enums.StateAddress;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyAddressDTO {
	
	@NotEmpty
	@Size(min = 5, max = 80)
	private String address;
	
	@NotEmpty
	@Size(min = 4, max = 30)
	private String district;
	
	@NotEmpty
	@Size(min = 4, max = 30)
	private String city;
	
	@Enumerated(EnumType.STRING)
	private StateAddress stateAddress;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cep;

}
