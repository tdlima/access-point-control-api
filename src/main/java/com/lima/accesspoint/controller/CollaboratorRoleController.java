package com.lima.accesspoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lima.accesspoint.dto.request.CollaboratorRoleDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.CollaboratorRoleService;

@RestController
@RequestMapping("/apc/v1/collaborator-role")
public class CollaboratorRoleController {
	
	@Autowired
	private CollaboratorRoleService collaboratorRoleService;
	
	@GetMapping
	public List<CollaboratorRoleDTO> listAll(){
		return collaboratorRoleService.listAll();
	}
	
	@GetMapping("/{id}")
	public CollaboratorRoleDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return collaboratorRoleService.listId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage create(@RequestBody @Valid CollaboratorRoleDTO collaboratorRoleDTO) {
		return collaboratorRoleService.save(collaboratorRoleDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid CollaboratorRoleDTO collaboratorRoleDTO) throws IdNotFoundException {
		return collaboratorRoleService.update(id, collaboratorRoleDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		collaboratorRoleService.delete(id);
	}

}







