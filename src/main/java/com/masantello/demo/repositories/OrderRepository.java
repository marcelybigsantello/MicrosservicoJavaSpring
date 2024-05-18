package com.masantello.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masantello.demo.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
