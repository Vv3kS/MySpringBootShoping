package com.example.Myshop.services;

import java.util.Optional;

import com.example.Myshop.entities.User;

public interface UserService {

	User saveUser(User user);

   User authenticateUser (String email , String password) ;
	
    Optional<User> getUserById(Long id);

    
    Optional<User> getUserByEmail(String email);

    Iterable<User> getAllUsers();

    void deleteUser(Long id);
}
