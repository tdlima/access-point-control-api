package com.lima.accesspoint.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BanckHoursDTO {
	
	@NotEmpty
	private BigDecimal balanceWorkedHours;

}
