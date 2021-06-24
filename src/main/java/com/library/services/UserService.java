package com.library.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.exceptions.EmailAlreadyExists;
import com.library.exceptions.PasswordEmpty;
import com.library.exceptions.UnableToLoginException;
import com.library.exceptions.UsernameAlreadyExists;
import com.library.models.User;
import com.library.models.UserTemplate;
import com.library.repositories.UserDAO;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpServletRequest req;

	public User register(UserTemplate template) {
		if(userDAO.existsByEmail(template.getEmail()))
			throw new EmailAlreadyExists();
		if(userDAO.existsByUsername(template.getUsername()))
			throw new UsernameAlreadyExists();
		User u = null;
		try {
			u = new User(
					0,
					template.getEmail().toLowerCase(),
					template.getUsername(),
					encrypt.encode(template.getPassword()),
					new ArrayList<>());
		}catch(IllegalArgumentException ex) {
			throw new PasswordEmpty();
		}
		MDC.put("POST event", "user/register endpoint");
		log.info("endpoint accessed");
		userDAO.save(u);
		log.info("New User with Id: " + u.getId());
		MDC.clear();
		return u;
	}

	public User login(String email, String password) {
		User u = userDAO.findByEmail(email).orElseThrow(() -> new UnableToLoginException());
		
		if(!u.getPassword().equals(password)) {
			throw new UnableToLoginException();
		}
		
		HttpSession session = req.getSession();
		req.changeSessionId();
		session.setAttribute("user", u);
		return u;
	}

	public void logout() {
		HttpSession session = req.getSession(false);
		if(session == null)
			return;
		session.invalidate();
	}
}
