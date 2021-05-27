package com.lima.accesspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.dto.request.CollaboratorDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.mapper.CollaboratorMapper;
import com.lima.accesspoint.model.Collaborator;
import com.lima.accesspoint.repository.CollaboratorRepository;
import com.lima.accesspoint.response.ResponseMessage;

@Service
public class CollaboratorService {
	
	private CollaboratorRepository collaboratorRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	
	private CollaboratorMapper collaboratorMapper = CollaboratorMapper.INSTANCE;
	
	@Autowired
	public CollaboratorService(CollaboratorRepository collaboratorRepository, CollaboratorMapper collaboratorMapper) {
		this.collaboratorRepository = collaboratorRepository;
		this.collaboratorMapper = collaboratorMapper;
	}
	

	public List<CollaboratorDTO> listAll() {
		List<Collaborator> collaborators = collaboratorRepository.findAll();
		return collaborators.stream()
				.map(collaboratorMapper::toDTO)
				.collect(Collectors.toList());
	}

	public CollaboratorDTO listId(Long id) throws IdNotFoundException {
		Collaborator collaborator = ifNotExistId(id);
		return collaboratorMapper.toDTO(collaborator);
	}
	
	public ResponseMessage save(CollaboratorDTO collaboratorDTO) {
		Collaborator collaboratorSave = collaboratorMapper.toModel(collaboratorDTO);
		Collaborator saveCollaborator = collaboratorRepository.save(collaboratorSave);
		return responseMessage.createMessage("The collaborator was created successfully with id ",saveCollaborator.getId());
	}

	public ResponseMessage update(Long id, CollaboratorDTO collaboratorDTO) throws IdNotFoundException {
		ifNotExistId(id);
		Collaborator collaboratorUpdt = collaboratorMapper.toModel(collaboratorDTO);
		Collaborator updtCollaborator = collaboratorRepository.save(collaboratorUpdt);
		return responseMessage.createMessage("The collaborator was updated successfully with id ",updtCollaborator.getId());
	}

	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		collaboratorRepository.deleteById(id);
	}
	
	public Collaborator ifNotExistId(Long id) throws IdNotFoundException {
		return collaboratorRepository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
	}
	
}











