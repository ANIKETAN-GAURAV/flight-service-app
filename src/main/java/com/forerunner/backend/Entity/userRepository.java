package com.forerunner.backend.Entity;

import com.forerunner.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {
}
