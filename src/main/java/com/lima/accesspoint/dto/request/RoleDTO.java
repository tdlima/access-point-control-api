package com.lima.accesspoint.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lima.accesspoint.enums.Roles;

import lombok.Data;

@Data
public class RoleDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
}
