package com.my.project.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.my.project.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;



@RestController
public class UserResource {
	
	private userDaoService service;
	
	
	
	
	public UserResource(userDaoService service, UserRepository repository) {
		this.service= service;
		
	}
	
	//GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		
		return service.findAll();
		
	}
	
	// http://localhost:8080/users
	// EntityModel
	//WebMvcLinkBuilder
	
	//GET /users
	@GetMapping("/jpa/users/{id}")
	public User retrieveUsers(@PathVariable int id){
		
		User user = service.findOne(id);
		
		//EntityModel<User> entityModel = EntityModel.of(user);
		
		//WebMvcLinkBuilder link = linkTo(methodOn(this.getClass().retriveAllUsers()));
		//entityModel.add(link.withRel("all-users"));
		
			
		return user;
			
		}
	
	
		
	
	
	
		@DeleteMapping("/jpa/users/{id}")
		public Object DeleteUsers(@PathVariable int id){
				
			return service.deletebyid(id);
				
			}
		
		
	
	
	
	//POST /users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = service.save(user);
		
		// users/4 => /users, {id}, user.getID
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}

}
