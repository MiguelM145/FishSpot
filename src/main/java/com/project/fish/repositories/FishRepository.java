package com.project.fish.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.fish.models.Fish;

@Repository
public interface FishRepository extends CrudRepository<Fish, Long>{
	List<Fish> findAll(); 
}
