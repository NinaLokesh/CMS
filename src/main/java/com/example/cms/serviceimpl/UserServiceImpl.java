package com.example.cms.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cms.dto.UserRequest;
import com.example.cms.dto.UserResponse;
import com.example.cms.exception.UserAlreadyExistsByEmailException;
import com.example.cms.model.User;
import com.example.cms.repository.UserRepository;
import com.example.cms.service.UserService;
import com.example.cms.utility.ResponseStructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private ResponseStructure<UserResponse> structure;
	private PasswordEncoder passwordEncoder;

	//	@Override
	//	public ResponseEntity<ResponseStructure<User>> registerUser(UserRequest userRequest) {
	//		User user = userRepo.save(mapToUser(userRequest, new User()));
	//		
	//		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
	//				.setMessage("User Registered")
	//				.setData(user)
	//				);
	//	}


	//	private User mapToUser(UserRequest userRequest, User user) {
	//		user.setUserName(userRequest.getUserName());
	//		user.setEmail(userRequest.getEmail());
	//		user.setPassword(userRequest.getPassword());
	//		return user;
	//	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> registerUser(UserRequest userRequest) {
		
		if(userRepo.existsByEmail(userRequest.getEmail()))
			throw new UserAlreadyExistsByEmailException("Failed to register user");

		User user = userRepo.save(mapToUserEntity(userRequest, new User()));
		
		return ResponseEntity.ok(structure.setStatusCode(HttpStatus.OK.value())
				.setMessage("User registered successfully")
				.setData(mapToUserResponse(user))
				);
	}

	
	private UserResponse mapToUserResponse(User user) {
		
		return UserResponse.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.email(user.getEmail())
				.createdAt(user.getCreatedAt())
				.lastModifiedAt(user.getLastModifiedAt())
				.build();
	}
	
	
	private User mapToUserEntity(UserRequest userRequest, User user) {

		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
//		user.setPassword(userRequest.getPassword());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		return user;
	}
}


