package com.lima.accesspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.dto.request.CollaboratorRoleDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.mapper.CollaboratorRoleMapper;
import com.lima.accesspoint.model.CollaboratorRole;
import com.lima.accesspoint.repository.CollaboratorRoleRepository;
import com.lima.accesspoint.response.ResponseMessage;

@Service
public class CollaboratorRoleService {
	
	@Autowired
	private CollaboratorRoleRepository collaboratorRoleRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Autowired
	private final CollaboratorRoleMapper collaboratorRoleMapper = CollaboratorRoleMapper.INSTANCE;

	public List<CollaboratorRoleDTO> listAll() {
		List<CollaboratorRole> collaborators = collaboratorRoleRepository.findAll();
		return collaborators.stream()
				.map(collaboratorRoleMapper::toDTO)
				.collect(Collectors.toList());
	}

	public CollaboratorRoleDTO listId(Long id) throws IdNotFoundException {
		CollaboratorRole collaboratorRole = ifNotExistId(id);
		return collaboratorRoleMapper.toDTO(collaboratorRole);
	}

	public ResponseMessage save(CollaboratorRoleDTO collaboratorRoleDTO) {
		CollaboratorRole collaboratorRoleSave = collaboratorRoleMapper.toModel(collaboratorRoleDTO);
		CollaboratorRole saveCollaboratorRole = collaboratorRoleRepository.save(collaboratorRoleSave);
		return responseMessage.createMessage("The collaborator role was created successfully with id ", saveCollaboratorRole.getId());
	}

	public ResponseMessage update(Long id, CollaboratorRoleDTO collaboratorRoleDTO) throws IdNotFoundException {
		ifNotExistId(id);
		CollaboratorRole collaboratorRoleUpdt = collaboratorRoleMapper.toModel(collaboratorRoleDTO);
		CollaboratorRole updtCollaboratorRole = collaboratorRoleRepository.save(collaboratorRoleUpdt);
		return responseMessage.createMessage("The collaborator role was updated successfully with id ", updtCollaboratorRole.getId());

	}

	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		collaboratorRoleRepository.deleteById(id);		
	}
	
	public CollaboratorRole ifNotExistId(Long id) throws IdNotFoundException {
		return collaboratorRoleRepository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
	}	

}
