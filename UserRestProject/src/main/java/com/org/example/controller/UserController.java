package com.org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.example.custom_exception.UserNotFoundException;
import com.org.example.dto.ErrorResponse;
import com.org.example.entity.User;
import com.org.example.service.UserService;

@RestController
@RequestMapping("/user") //add layer to avoid further name conflict
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		User createdUser = userService.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?>getAllUsers(){
		try {
			
			return new ResponseEntity<>(userService.fetchAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			ErrorResponse errRes = new ErrorResponse("user fetching fail", e.getMessage());
			return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
		}		
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> fetchUserById(@PathVariable Integer id){
		try {
			return ResponseEntity.ok(userService.fetchbyId(id));
			
		} catch (RuntimeException e) {
			ErrorResponse errRes = new ErrorResponse("Not Found", e.getMessage());
			return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody User updateUser){
		try {
			
			User existingUser = userService.fetchbyId(id);
			return ResponseEntity.ok
					(userService.update(updateUser, existingUser));
	
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse
				("User updation Failed", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
		try {
			User existingUser = userService.fetchbyId(id);
			return ResponseEntity.ok(userService.delete(existingUser));
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse
		("User Deletion Failed", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<?> getUserByUserName(@PathVariable String name){
		try {
			ResponseEntity res = null;
			User foundUser = userService.fetchUserByUserName(name);
			System.out.println(foundUser);
			if(foundUser == null) {
				throw new UserNotFoundException("Invalid Username...");
				 
			}
			else {
				res = new ResponseEntity(foundUser, HttpStatus.OK);
			}
			return res;
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Fetching user by username failed",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	
	}
	
}
