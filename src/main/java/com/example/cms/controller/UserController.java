package com.example.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponse;
import com.example.cms.dto.UserResponse;
import com.example.cms.model.User;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponseStructure;

@RestController
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping(value="/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody UserRequest userRequest ) {
		return userService.registerUser(userRequest);
	}
	
	@GetMapping(value="/users/test")
	public String test(){
		return "Hello from CMS";
	}
	
	@DeleteMapping(value="/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(@PathVariable int userId) {
		return userService.deleteUserById(userId);
	}
	
	@GetMapping(value="/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId) {
		return userService.findUserById(userId);
	}

}

