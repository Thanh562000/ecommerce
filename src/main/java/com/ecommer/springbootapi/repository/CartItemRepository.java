package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.CartItem;
import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCustomer(User customer);


}
