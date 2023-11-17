package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product  p WHERE p.title LIKE CONCAT('%',:query,'%') OR p.keywords LIKE CONCAT('%', :query,'%')")
    List<Product> searchProduct(String query);
}
