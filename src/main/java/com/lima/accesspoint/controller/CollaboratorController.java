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

import com.lima.accesspoint.dto.request.CollaboratorDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.CollaboratorService;

@RestController
@RequestMapping("/apc/v1/collaborator")
public class CollaboratorController {
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	@GetMapping
	public List<CollaboratorDTO> listAll() {
		return collaboratorService.listAll();	
	}
	
	@GetMapping("/{id}")
	public CollaboratorDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return collaboratorService.listId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage create(@RequestBody @Valid CollaboratorDTO collaboratorDTO) {
		return collaboratorService.save(collaboratorDTO);		
	}

	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid CollaboratorDTO collaboratorDTO) throws IdNotFoundException {
		return collaboratorService.update(id, collaboratorDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		collaboratorService.delete(id);
	}
	
}







