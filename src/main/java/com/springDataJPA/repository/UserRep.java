package com.springDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springDataJPA.entity.UserEntity;

public interface UserRep extends JpaRepository<UserEntity, Long> {

}
