package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
