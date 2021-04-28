package com.onlineshoppingsystem.project.data.cart;

import com.onlineshoppingsystem.project.data.cart.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long > {
}
