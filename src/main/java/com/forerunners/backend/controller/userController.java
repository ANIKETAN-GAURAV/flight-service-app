package com.forerunners.backend.controller;

import com.forerunners.backend.Dto.UserObj;
import com.forerunners.backend.Dto.Users;
import com.forerunners.backend.Repository.UserRepository;
import com.forerunners.backend.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Status loginUser(@RequestBody UserObj userBody){

        try {
            Users user = userRepository.findUsersByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
                    userBody.getSeatNo(), userBody.getPassword());

            if (user != null) {
                return Status.SUCCESS;
            } else
                return Status.FAILURE;
        }
        catch (Exception e)
        {
            return Status.FAILURE;
        }

    }

    @PostMapping("/addServices")
    public Status addServices(@RequestBody Users userBody){

        Users user = userRepository.findUsersByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
                userBody.getSeatNo(), userBody.getPassword());

        user.setFoodItems(userBody.getFoodItems() == null ? user.getFoodItems(): userBody.getFoodItems());
        user.setHealthInfo(userBody.getHealthInfo() == null ? user.getHealthInfo(): userBody.getHealthInfo());
        user.setQuery(userBody.getQuery() == null ? user.getQuery(): userBody.getQuery());

        if(user.getQuery() == null && user.getFoodItems() == null)
            user.setAnyOrder(0);
        else
            user.setAnyOrder(1);

        user.setCreatedTime(new java.util.Date());

        try {
            userRepository.save(user);
        }
        catch (Exception e) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

}
