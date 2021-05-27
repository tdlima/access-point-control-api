package com.lima.accesspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lima.accesspoint.dto.request.CollaboratorRoleDTO;
import com.lima.accesspoint.model.CollaboratorRole;

@Mapper(componentModel = "spring")
public interface CollaboratorRoleMapper {
	
	CollaboratorRoleMapper INSTANCE = Mappers.getMapper(CollaboratorRoleMapper.class);
	
	CollaboratorRole toModel(CollaboratorRoleDTO collaboratorRoleDTO);
	
	CollaboratorRoleDTO toDTO(CollaboratorRole collaboratorRole);
	
}
