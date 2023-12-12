package com.project.fish.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.project.fish.models.LoginUser;
import com.project.fish.models.User;
import com.project.fish.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	
	public User register(User newUser, BindingResult result) {
		Optional<User> passUser = userRepo.findByEmail(newUser.getEmail());
		if(passUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already in use!");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match password");
		}
		
		if(result.hasErrors()) {
			return null; 
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> passUser = userRepo.findByEmail(newLoginObject.getEmail());
		
		if(!passUser.isPresent()) {
			result.rejectValue("email", "Matches", "User is not found!");
			return null; 
		}
		
		User user = passUser.get(); 
		
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if(result.hasErrors()) {
			return null; 
		}
		return user; 
	}
	
	public User findById(Long id) {
		Optional<User> passUser = userRepo.findById(id);
		if(passUser.isPresent()) {
			return passUser.get(); 
		}
		return null; 
	}
}