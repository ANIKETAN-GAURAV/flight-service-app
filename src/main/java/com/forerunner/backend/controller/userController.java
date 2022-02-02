package com.forerunner.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forerunner.backend.Dto.User;
import com.forerunner.backend.Dto.UserObj;
import com.forerunner.backend.Repository.staffRepository;
import com.forerunner.backend.Repository.userRepository;
import com.forerunner.backend.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://stickynotesfrontend-339809.uc.r.appspot.com/")
@RestController
@RequestMapping("/api/v1/user")
public class userController {

    @Autowired
    private staffRepository noteRepository;
    @Autowired
    private com.forerunner.backend.Repository.userRepository userRepository;

    @PostMapping("/login")
    public Status loginUser(@RequestBody UserObj userBody){

        User user = userRepository.findUserByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
                userBody.getSeatNo(), userBody.getPassword());

        if (user != null) {
            return Status.SUCCESS;
        } else
        return Status.FAILURE;
    }

    @PostMapping("/addServices")
    public Status addServices(@RequestBody User userBody){

        User user = userRepository.findUserByPnrAndUserNameAndSeatNoAndPassword(userBody.getPnr(), userBody.getUserName(),
                userBody.getSeatNo(), userBody.getPassword());

        user.setFoodItems(userBody.getFoodItems() == null ? user.getFoodItems(): userBody.getFoodItems());
        user.setHealthInfo(userBody.getHealthInfo() == null ? user.getHealthInfo(): userBody.getHealthInfo());
        user.setQuery(userBody.getQuery() == null ? user.getQuery(): userBody.getQuery());

        if(user.getQuery() == null && user.getFoodItems() == null)
            user.setAnyOrder(false);
        else
            user.setAnyOrder(true);

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
