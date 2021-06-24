package com.library.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.models.Book;
import com.library.models.User;
import com.library.repositories.BookDAO;
import com.library.repositories.UserDAO;

@Service
public class AdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	public List<User> findAllUsers(){
		return userDAO.findAll();
	}
	
	public List<Book> findAllBooks(){
		return bookDAO.findAll();
	}
}
