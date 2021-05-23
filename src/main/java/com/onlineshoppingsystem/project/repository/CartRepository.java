package com.onlineshoppingsystem.project.repository;

import com.onlineshoppingsystem.project.data.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
