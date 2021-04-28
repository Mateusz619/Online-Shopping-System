package com.onlineshoppingsystem.project.repository;

import com.onlineshoppingsystem.project.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}