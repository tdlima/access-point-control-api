package com.lima.accesspoint.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.dto.request.RoleDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.mapper.RoleMapper;
import com.lima.accesspoint.model.Role;
import com.lima.accesspoint.repository.RoleRepository;
import com.lima.accesspoint.response.ResponseMessage;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ResponseMessage responseMessage;
	
	@Autowired
	private final RoleMapper roleMapper = RoleMapper.INSTANCE;

	public List<RoleDTO> listAll() {
		List<Role> collaborators = roleRepository.findAll();
		return collaborators.stream()
				.map(roleMapper::toDTO)
				.collect(Collectors.toList());
	}

	public RoleDTO listId(Long id) throws IdNotFoundException {
		Role role = ifNotExistId(id);
		return roleMapper.toDTO(role);
	}

	public ResponseMessage save(RoleDTO roleDTO) {
		Role roleSave = roleMapper.toModel(roleDTO);
		Role saveRole = roleRepository.save(roleSave);
		return responseMessage.createMessage("The collaborator role was created successfully with id ", saveRole.getId());
	}

	public ResponseMessage update(Long id, RoleDTO roleDTO) throws IdNotFoundException {
		ifNotExistId(id);
		Role roleUpdate = roleMapper.toModel(roleDTO);
		Role updateRole = roleRepository.save(roleUpdate);
		return responseMessage.createMessage("The collaborator role was updated successfully with id ", updateRole.getId());

	}

	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		roleRepository.deleteById(id);		
	}
	
	public Role ifNotExistId(Long id) throws IdNotFoundException {
		return roleRepository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
	}	

}
