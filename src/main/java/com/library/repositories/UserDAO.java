package com.library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.models.User;

public interface UserDAO extends JpaRepository<User, Integer>{

	public boolean existsByUsername(String username);
	
	public boolean existsByEmail(String email);
	
	public Optional<User> findByEmail(String email);
}
