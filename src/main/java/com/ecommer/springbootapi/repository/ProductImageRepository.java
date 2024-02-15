package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ImageData, Long> {
}
