package com.forerunners.backend.controller;

import com.forerunners.backend.Dto.StaffObj;
import com.forerunners.backend.Dto.Staffs;
import com.forerunners.backend.Dto.Users;
import com.forerunners.backend.Repository.StaffRepository;
import com.forerunners.backend.Repository.UserRepository;
import com.forerunners.backend.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/staff")
public class staffController {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    public Status loginStaff(@RequestBody StaffObj staffBody){

        try {
            Staffs staff = staffRepository.findStaffsByMemberIdAndPnrAndPassword(staffBody.getMemberId(), staffBody.getPnr(), staffBody.getPassword());

            if (staff != null) {
                return Status.SUCCESS;
            } else
                return Status.FAILURE;
        }
        catch(Exception e) {
            return Status.FAILURE;
        }
    }

    @GetMapping("/viewServices")
    public List<Users> viewServices(){

        List<Users> users = userRepository.findAllByAnyOrderOrderByCreatedTime(1);

        return users;
    }

    @PostMapping("/completeOrder")
    public Status completeOrder(@RequestBody Users userBody)
    {
      Users user = userRepository.findUsersByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
              userBody.getSeatNo(), userBody.getPassword());

      try {
          user.setAnyOrder(0);
          user.setQuery(null);
          user.setFoodItems(null);

          userRepository.save(user);
      }
      catch (Exception e)
      {
          return Status.FAILURE;
      }
     return Status.SUCCESS;
    }

}
