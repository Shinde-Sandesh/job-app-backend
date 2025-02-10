package com.example.SpringJobApp;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.SpringJobApp.usermodel.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringJobApp.service.UserActivityService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

	@Autowired
	private UserActivityService service;
	
	@PostMapping("register")
	private User registerUser (@RequestBody User user) {
		return service.saveUser(user);
	}
}



