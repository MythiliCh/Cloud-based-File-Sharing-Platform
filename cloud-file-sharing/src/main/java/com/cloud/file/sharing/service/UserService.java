package com.cloud.file.sharing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.file.sharing.entity.User;
import com.cloud.file.sharing.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
}
