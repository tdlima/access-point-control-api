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

import com.lima.accesspoint.dto.request.CompanyDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Company")
@RestController
@RequestMapping("/apc/v1/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@ApiOperation(value = "List all")
	@GetMapping
	public List<CompanyDTO> listAll() {
		return companyService.listAll();
	}
	
	@ApiOperation(value = "List by Id")
	@GetMapping("/{id}")
	public CompanyDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return companyService.listId(id);
	}
	
	@ApiOperation(value = "Save")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage save(@RequestBody @Valid CompanyDTO companyDTO) {
		return companyService.save(companyDTO);
	}
	
	@ApiOperation(value = "Update")
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid CompanyDTO companyDTO) throws IdNotFoundException {
		return companyService.update(id, companyDTO);
	}
	
	@ApiOperation(value = "Delete")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		companyService.delete(id);
	}

}










