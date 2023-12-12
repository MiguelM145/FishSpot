 package com.project.fish.models;


import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="fishies")
public class Fish {
	//fish table model
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	private String fishName; 
	
	@OneToMany(mappedBy = "fish", fetch=FetchType.LAZY)
	private List<FishUser> users;  
	
	public Fish() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}


	public List<FishUser> getUsers() {
		return users;
	}

	public void setUsers(List<FishUser> users) {
		this.users = users;
	}
	

}
