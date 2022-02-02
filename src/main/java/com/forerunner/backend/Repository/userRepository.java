package com.forerunner.backend.Repository;

import com.forerunner.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User, Long> {
    User findUserByPnrAndUserNameAndSeatNoAndPassword(String pnr, String userName,String seatNo, String password);
    String findQueryByPnr(Long id, String userName);
    List<User> findAllByAnyOrder(Boolean anyOrder);
}
