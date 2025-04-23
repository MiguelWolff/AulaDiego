package br.com.unicuritiba.projectstreaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.projectstreaming.models.User;
import br.com.unicuritiba.projectstreaming.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id){
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User savedUser = repository.save(user);
		return ResponseEntity.ok(savedUser);
	}
	
	@DeleteMapping("/users/{id}")
	public void removeUser(@PathVariable long id, @RequestBody User user) {
		repository.deleteById(id);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
		user.setId(id);
		User savedUser = repository.save(user);
		return ResponseEntity.ok(savedUser);
	}
}
