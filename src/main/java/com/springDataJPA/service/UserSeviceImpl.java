package com.springDataJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springDataJPA.entity.UserEntity;
import com.springDataJPA.repo.UserRep;

@Service
public class UserSeviceImpl implements UserService {
	
	private UserRep userRepo;
	
	public UserSeviceImpl(UserRep userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserEntity saveUser(UserEntity entity) {

		UserEntity savedEntity = userRepo.save(entity);
		return savedEntity;
	}

	@Override
	public List<UserEntity> getUser() {
		List<UserEntity> all = userRepo.findAll();
		return all;
	}

	@Override
	public UserEntity updateUser(UserEntity incomingEntity) {
		
		Optional<UserEntity> user = userRepo.findById(incomingEntity.getId());
		
		
		if(user.isPresent()) {
			
			 UserEntity savedUser = user.get();
			 savedUser.setId(incomingEntity.getId());
			 savedUser.setName(incomingEntity.getName());
			 savedUser.setAge(incomingEntity.getAge());
			 savedUser.setContactNo(incomingEntity.getContactNo());
			 savedUser.setEmail(incomingEntity.getEmail());
			 
			return userRepo.save(savedUser);
			 
		}
		else {
			
			return null;
		}
		
	}

	@Override
	public boolean deleteUser(Long id) {
		userRepo.deleteById(id);
		return true;
		
	}
	

}
