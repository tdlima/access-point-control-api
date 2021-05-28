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

import com.lima.accesspoint.dto.request.RoleDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Role")
@RestController
@RequestMapping("/apc/v1/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ApiOperation(value = "List all")
	@GetMapping
	public List<RoleDTO> listAll(){
		return roleService.listAll();
	}
	
	@ApiOperation(value = "List by Id")
	@GetMapping("/{id}")
	public RoleDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return roleService.listId(id);
	}
	
	@ApiOperation(value = "Save")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage save(@RequestBody @Valid RoleDTO roleDTO) {
		return roleService.save(roleDTO);
	}
	
	@ApiOperation(value = "Update")
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid RoleDTO roleDTO) throws IdNotFoundException {
		return roleService.update(id, roleDTO);
	}
	
	@ApiOperation(value = "Delete")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		roleService.delete(id);
	}

}







