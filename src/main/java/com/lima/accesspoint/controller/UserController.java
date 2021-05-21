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
import com.lima.accesspoint.model.User;
import com.lima.accesspoint.service.UserService;
import com.lima.accesspoint.service.response.ResponseMessage;

import lombok.Data;

@Data
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseMessage create(@RequestBody User user) {
		return userService.save(user);		
	}
	
	@GetMapping
	public List<User> listAll() {
		return userService.listAll();	
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) throws IdNotFoundException {
		return userService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws IdNotFoundException {
		userService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseMessage update(@PathVariable Long id, @RequestBody User user) throws IdNotFoundException {
		return userService.update(id, user);
	}

}







