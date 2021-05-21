package com.lima.accesspoint.controller;

import java.util.List;

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

import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.model.Company;
import com.lima.accesspoint.service.CompanyService;
import com.lima.accesspoint.service.response.ResponseMessage;

import lombok.Data;

@Data
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	public List<Company> listAll() {
		return companyService.listAll();
	}
	
	@GetMapping("/{id}")
	public Company listId(@PathVariable Long id) throws IdNotFoundException {
		return companyService.listId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage create(@RequestBody Company company) {
		return companyService.create(company);
	}
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody Company company) throws IdNotFoundException {
		return companyService.update(id, company);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		companyService.delete(id);
	}

}










