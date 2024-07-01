package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;

@Service
public class UserRoleService implements IUserRoleService {

	private final Logger logger = LoggerFactory.getLogger(UserRoleService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<User> getUsersByRole(String rolename) {
		return userRepository.findAllByRolename(rolename);
	}

	@Override
	public List<Role> getRolesByUser(Long userId) {
		
		//Integer uid = userId;
		Optional<User> userOptional = userRepository.findById(userId.intValue());
		User user = userOptional.orElseThrow(() -> new IllegalArgumentException("User not found"));
		return  user.getRoles();
	}


}
