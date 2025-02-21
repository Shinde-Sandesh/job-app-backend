package com.example.SpringJobApp.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringJobApp.usermodel.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
