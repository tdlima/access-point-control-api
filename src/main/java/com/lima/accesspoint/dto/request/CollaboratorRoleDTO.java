package com.lima.accesspoint.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lima.accesspoint.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorRoleDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
}
