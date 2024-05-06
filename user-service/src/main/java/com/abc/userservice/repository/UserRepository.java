package com.abc.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.userservice.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
