package com.forerunner.backend.Entity;

import com.forerunner.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffRepository extends JpaRepository<User, Long> {
}
