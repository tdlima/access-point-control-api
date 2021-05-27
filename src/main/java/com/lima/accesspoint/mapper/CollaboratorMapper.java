package com.lima.accesspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lima.accesspoint.dto.request.CollaboratorDTO;
import com.lima.accesspoint.model.Collaborator;


@Mapper(componentModel = "spring")
public interface CollaboratorMapper {
	
	CollaboratorMapper INSTANCE = Mappers.getMapper(CollaboratorMapper.class);
	
	Collaborator toModel(CollaboratorDTO collaboratorDTO);
	
	CollaboratorDTO toDTO(Collaborator collaborator);
	
}
