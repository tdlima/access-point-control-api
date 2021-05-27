package com.lima.accesspoint.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lima.accesspoint.enums.ContractType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkdayDTO {
	
	private Long id;
	
	@Size(min = 10, max = 80)
	@NotEmpty
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ContractType contractType;

}
