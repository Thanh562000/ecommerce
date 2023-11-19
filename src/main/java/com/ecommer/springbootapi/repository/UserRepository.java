package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUserNameOrEmail(String username, String email);

    Optional<User> findByUserName(String username);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

}
