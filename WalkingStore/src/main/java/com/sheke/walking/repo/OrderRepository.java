package com.sheke.walking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheke.walking.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
