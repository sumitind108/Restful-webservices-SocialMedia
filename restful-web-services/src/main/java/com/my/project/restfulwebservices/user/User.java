package com.my.project.restfulwebservices.user;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {
	
	protected User() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2, message = "Name should have at least 2 charectors")
	//@JsonProperty("user_name")
	private String name;
	@Past(message= "Birth Date should be in the past")
	//@JsonProperty("Birth_date")
	private LocalDate DateOfBirth;
	
//	@OneToMany(mappedBy= "user")
	@JsonIgnore
//	private List<Post> posts;
	
	
	public User(int id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		DateOfBirth = dateOfBirth;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DateOfBirth=" + DateOfBirth + "]";
	}


//	public List<Post> getPosts() {
//		return posts;
//	}


//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}


//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", DateOfBirth=" + DateOfBirth  "];"
//	}



	
	
	
	

}
