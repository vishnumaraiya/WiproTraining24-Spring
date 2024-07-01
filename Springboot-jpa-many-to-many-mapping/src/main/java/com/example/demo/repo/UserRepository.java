package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :x")
    List<User> findAllByRolename(@Param("x") String rolename);

    //List<User> findAllByRoles(Role role);
	
	//Optional<User> findAll(Long userId);



}
	