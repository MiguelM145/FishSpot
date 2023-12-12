package com.project.fish.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fish.models.Fish;
import com.project.fish.repositories.FishRepository;

@Service	
public class FishService {
	@Autowired
	FishRepository fishRepository; 
	
	public List<Fish> allFish(){
		return fishRepository.findAll(); 
	}
	
	public Fish createFish(Fish fish) {
		return fishRepository.save(fish);
	}
	
	public Fish findFish(Long id) {
		Optional<Fish> optionalFish = fishRepository.findById(id);
		if(optionalFish.isPresent()) {
			return optionalFish.get(); 
		}else {
			return null; 
		}
	}
	
	public Fish updateFish(Fish fish) {
		return fishRepository.save(fish); 
	}
	
	public void deleteFish(Fish fish) {
		fishRepository.delete(fish);
	}
	
	
}
