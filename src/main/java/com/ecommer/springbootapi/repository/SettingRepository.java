package com.ecommer.springbootapi.repository;

import com.ecommer.springbootapi.entities.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
