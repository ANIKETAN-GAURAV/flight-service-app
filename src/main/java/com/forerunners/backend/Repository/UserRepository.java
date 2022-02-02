package com.forerunners.backend.Repository;

import com.forerunners.backend.Dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersByPnrAndUserNameAndSeatNoAndPassword(String pnr, String userName, String seatNo, String password);
    List<Users> findAllByAnyOrderOrderByCreatedTime(Integer any_order);
}
