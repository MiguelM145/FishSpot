package com.project.fish.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="fishies_users")
public class FishUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull(message="Dont hide the location!")	
	@Size(min = 1, max = 30, message="Dont hide the location!")
	private String areaCaught; 
	
	@NotNull(message="Cant leave the time empty!")	
	@Size(min = 1, max = 30, message="Cant leave the time empty!")
	private String timeOfDay; 
	
	@NotNull(message="Please share about your catch!")
	@Size(min = 1, max = 255, message="Please share about your catch!")
	private String description;
	
	@Column(updatable=false)
	private Date createdAt; 
	private Date updatedAt; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fish_id")
	private Fish fish; 
	
	public FishUser() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public String getAreaCaught() {
		return areaCaught;
	}

	public void setAreaCaught(String areaCaught) {
		this.areaCaught = areaCaught;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
