package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product  p WHERE p.title LIKE CONCAT('%',:query,'%') OR p.keywords LIKE CONCAT('%', :query,'%')")
    List<Product> searchProduct(String query);
}
