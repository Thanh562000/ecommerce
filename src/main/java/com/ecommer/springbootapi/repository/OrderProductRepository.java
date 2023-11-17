package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProducts, Long> {
}
