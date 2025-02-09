package com.example.SpringJobApp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SpringJobApp.repo.user.UserRepo;
import com.example.SpringJobApp.usermodel.User;
import com.example.SpringJobApp.usermodel.implementation.UserDetailsImplementation;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);

		if (user == null) {
			System.out.println("User 404");
			throw new UsernameNotFoundException("User 404");
		}
		return new UserDetailsImplementation(user);
	}

}
