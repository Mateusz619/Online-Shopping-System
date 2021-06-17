package com.onlineshoppingsystem.project.repository;

import com.onlineshoppingsystem.project.data.UserInternal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInternal, Long> {

    Optional<UserInternal> findByUsername(String username);

}