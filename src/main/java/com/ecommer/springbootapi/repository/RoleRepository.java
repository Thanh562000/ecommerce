package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
