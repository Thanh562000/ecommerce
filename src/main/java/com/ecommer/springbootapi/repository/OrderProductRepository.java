package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.OrderProducts;
import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProducts, Long> {
    List<OrderProducts> findByCustomer(User customer);
}
