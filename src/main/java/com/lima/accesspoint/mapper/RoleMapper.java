package com.lima.accesspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lima.accesspoint.dto.request.RoleDTO;
import com.lima.accesspoint.model.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	Role toModel(RoleDTO roleDTO);
	
	RoleDTO toDTO(Role Role);
	
}
