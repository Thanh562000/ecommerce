package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}
