package com.lima.accesspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lima.accesspoint.exception.IdNotFoundException;
import com.lima.accesspoint.model.User;
import com.lima.accesspoint.repository.UserRepository;
import com.lima.accesspoint.service.response.ResponseMessage;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseMessage save(User user) {		
		User saveUser = userRepository.save(user);
		return createMessage("The workday was created successfully with id ",saveUser.getId());
	}

	public List<User> listAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) throws IdNotFoundException {
		User user = ifNotExistId(id);
		return user;
	}

	public void delete(Long id) throws IdNotFoundException {
		ifNotExistId(id);
		userRepository.deleteById(id);
	}
	
	public ResponseMessage update(Long id, User user) throws IdNotFoundException {
		ifNotExistId(id);
		User userUpdate = userRepository.save(user);
		return createMessage("The workday was updated successfully with id ",userUpdate.getId());
	}
	
	public User ifNotExistId(Long id) throws IdNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(()-> new IdNotFoundException(id));
	}
	
	public ResponseMessage createMessage(String message, Long id) {
		return ResponseMessage.builder()
				.message(message + id)
				.build();
	}
	
}











