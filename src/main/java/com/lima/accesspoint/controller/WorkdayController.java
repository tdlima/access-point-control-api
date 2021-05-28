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

import com.lima.accesspoint.dto.request.WorkdayDTO;
import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.response.ResponseMessage;
import com.lima.accesspoint.service.WorkdayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Workday")
@RestController
@RequestMapping("/apc/v1/workday")
public class WorkdayController {
	
	@Autowired
	private WorkdayService workdayService;
	
	@ApiOperation(value = "List all")
	@GetMapping
	public List<WorkdayDTO> listAll() {
		return workdayService.listAll();
	}
	
	@ApiOperation(value = "List by Id")
	@GetMapping("/{id}")
	public WorkdayDTO listId(@PathVariable Long id) throws IdNotFoundException {
		return workdayService.listId(id);
	}
	
	@ApiOperation(value = "Save")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage save(@RequestBody @Valid WorkdayDTO workdayDTO) {
		return workdayService.save(workdayDTO);
	}
	
	@ApiOperation(value = "Update")
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody @Valid WorkdayDTO workdayDTO) throws IdNotFoundException {
		return workdayService.update(id, workdayDTO);
	}
	
	@ApiOperation(value = "Delete")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		workdayService.delete(id);
	}
}














