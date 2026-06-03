package com.springDataJPA.service;

import java.util.List;

import com.springDataJPA.entity.UserEntity;

public interface UserService {
	
	UserEntity saveUser(UserEntity entity);
	
	List<UserEntity> getUser();
	
	UserEntity updateUser(UserEntity entity);
	
	boolean deleteUser(Long id);
	

}
