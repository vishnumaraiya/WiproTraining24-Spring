package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.IUserRoleService;

@RestController
public class UserRoleController {
	@Autowired
	private IUserRoleService userRoleService;
	
	@GetMapping("/hello")
	public String hello() {
        return "Hello World, Spring Boot.... Welcome to You!";
    }

	@GetMapping("/users/{roleName}")
	public List<User> getUsersByRole(@PathVariable String roleName) {
		return userRoleService.getUsersByRole(roleName);
	}

	@GetMapping("/roles/{userId}")
	public List<Role> getRolesByUser(@PathVariable Long userId) {
		return userRoleService.getRolesByUser(userId);
	}
}