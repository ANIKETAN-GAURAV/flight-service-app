package com.forerunners.backend.Repository;

import com.forerunners.backend.Dto.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staffs, Long> {
    Staffs findStaffsByMemberIdAndPnrAndPassword(String memberId, String pnr, String password);

}
