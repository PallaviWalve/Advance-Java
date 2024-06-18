package com.org.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.example.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUserName(String name);
}
