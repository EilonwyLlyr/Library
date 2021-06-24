package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Book;
import com.library.models.User;
import com.library.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(adminService.findAllUsers());
	}
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(adminService.findAllBooks());
	}
}
