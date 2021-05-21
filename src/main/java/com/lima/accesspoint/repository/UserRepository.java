package com.lima.accesspoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lima.accesspoint.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
