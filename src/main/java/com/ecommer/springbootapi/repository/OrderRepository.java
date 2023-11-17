package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
