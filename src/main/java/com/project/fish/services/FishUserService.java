package com.project.fish.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fish.models.FishUser;
import com.project.fish.repositories.FishUserRepo;

@Service
public class FishUserService {
	@Autowired
	FishUserRepo fishUserRepo;
	
	public List<FishUser> allFishUsers(){
		return fishUserRepo.findAll();
	}
	
	public FishUser createFishUser(FishUser fishUser) {
		return fishUserRepo.save(fishUser);
	}
	
	public FishUser findFishUsers(Long id) {
		Optional<FishUser> optionalFishUser = fishUserRepo.findById(id);
		if(optionalFishUser.isPresent()) {
			return optionalFishUser.get(); 
		}else {
			return null; 
		}
	}

	public FishUser updateFishUser(FishUser fishUser) {
		return fishUserRepo.save(fishUser);
	}
	
	public void deletefishUser(FishUser fishUser) {
		fishUserRepo.delete(fishUser);
	}
	
}
