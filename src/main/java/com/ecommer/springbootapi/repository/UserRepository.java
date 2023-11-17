package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
