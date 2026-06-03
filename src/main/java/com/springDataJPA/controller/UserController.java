package com.springDataJPA.controller;

import java.util.List;

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

import com.springDataJPA.entity.UserEntity;
import com.springDataJPA.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody UserEntity entity){
		
		UserEntity saveUser = userService.saveUser(entity);
		
		if(null!= saveUser) {
			return ResponseEntity.ok(saveUser);
		}
		return  new ResponseEntity<>("User not found",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserEntity>> getAllUser(){
		
		List<UserEntity> users = userService.getUser();
		
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity entity){
		
		UserEntity updateUser = userService.updateUser(entity);
		

		if(null!= updateUser) {
			return ResponseEntity.ok(updateUser);
		}
		return  new ResponseEntity<>("User not found",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		boolean deleteUser = userService.deleteUser(id);
		if(deleteUser) {
			return new ResponseEntity<>("User deleted successfully:"+id,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not deleted:"+id,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	

}
