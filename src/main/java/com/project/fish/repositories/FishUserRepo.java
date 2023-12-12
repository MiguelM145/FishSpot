package com.project.fish.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.fish.models.FishUser;

@Repository
public interface FishUserRepo extends CrudRepository<FishUser, Long>{
	List<FishUser> findAll(); 
}
