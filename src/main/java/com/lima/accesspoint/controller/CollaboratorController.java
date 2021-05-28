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
import com.lima.accesspoint.dto.response.CollaboratorRspDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.CollaboratorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Collaborators")
@RestController
@RequestMapping("/apc/v1/collaborator")
public class CollaboratorController {
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	@ApiOperation(value = "List all")
	@GetMapping
	public List<CollaboratorRspDTO> listAll() {
		return collaboratorService.listAll();	
	}
	
	@ApiOperation(value = "List by Id")
	@GetMapping("/{id}")
	public CollaboratorRspDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return collaboratorService.listId(id);
	}
	
	@ApiOperation(value = "Save")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage save(@RequestBody @Valid CollaboratorDTO collaboratorDTO) {
		return collaboratorService.save(collaboratorDTO);		
	}
	
	@ApiOperation(value = "Update")
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid CollaboratorDTO collaboratorDTO) throws IdNotFoundException {
		return collaboratorService.update(id, collaboratorDTO);
	}
	
	@ApiOperation(value = "Delete")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		collaboratorService.delete(id);
	}
	
}







