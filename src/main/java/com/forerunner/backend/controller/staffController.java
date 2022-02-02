package com.forerunner.backend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.forerunner.backend.Dto.Staff;
import com.forerunner.backend.Dto.StaffObj;
import com.forerunner.backend.Dto.User;
import com.forerunner.backend.Dto.UserObj;
import com.forerunner.backend.Repository.staffRepository;
import com.forerunner.backend.Repository.userRepository;
import com.forerunner.backend.Status;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://stickynotesfrontend-339809.uc.r.appspot.com/")
@RestController
@RequestMapping("/api/v1/staff")
public class staffController {

    staffRepository staffRepository;
    userRepository userRepository;
    @PostMapping("/login")
    public Status loginStaff(@RequestBody StaffObj staffBody){

        Staff staff = staffRepository.findStaffByMember_idAndPnrAndPassword(staffBody.getMember_id(), staffBody.getPnr(), staffBody.getPassword());

        if (staff != null) {
            return Status.SUCCESS;
        } else
            return Status.FAILURE;
    }

    @GetMapping("/viewServices")
    public List<User> viewServices(){

        List<User> users = userRepository.findAllByAnyOrder(true);

        JSONObject json = new JSONObject();

        return users;
    }

    @PostMapping("/acceptOrDecline")
    public Status isAcceptOrDecline(@RequestBody User userBody)
    {
      User user = userRepository.findUserByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
              userBody.getSeatNo(), userBody.getSeatNo());

      try {
          user.setAnyOrder(false);
      }
      catch (Exception e)
      {
          return Status.FAILURE;
      }
     return Status.SUCCESS;
    }

}
