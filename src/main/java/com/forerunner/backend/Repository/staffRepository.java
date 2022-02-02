package com.forerunner.backend.Repository;

import com.forerunner.backend.Dto.Staff;
import com.forerunner.backend.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffRepository extends JpaRepository<Staff, Long> {
    Staff findStaffByMember_idAndPnrAndPassword(String member_id, String pnr, String password);

}
