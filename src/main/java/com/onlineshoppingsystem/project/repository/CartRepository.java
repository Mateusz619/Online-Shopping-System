package com.onlineshoppingsystem.project.repository;

import com.onlineshoppingsystem.project.data.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Product, Long> {
    List<Product> findAllById(Id id);

}

