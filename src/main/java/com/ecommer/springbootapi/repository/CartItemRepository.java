package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
