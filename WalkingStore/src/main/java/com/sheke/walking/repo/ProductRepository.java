package com.sheke.walking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheke.walking.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
