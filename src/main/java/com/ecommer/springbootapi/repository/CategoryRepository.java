package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
