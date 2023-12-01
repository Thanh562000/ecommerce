package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Order;
import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(User customer);

}
