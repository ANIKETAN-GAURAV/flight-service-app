package com.forerunner.backend.controller;

import com.forerunner.backend.Dto.User;
import com.forerunner.backend.Entity.staffRepository;
import com.forerunner.backend.Entity.userRepository;
import com.forerunner.backend.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "https://stickynotesfrontend-339809.uc.r.appspot.com/")
@RestController
@RequestMapping("/api/v1/staff")
public class staffController {

    @Autowired
    private staffRepository noteRepository;
    @Autowired
    private userRepository userRepository;

    @PostMapping("/")
    public Status loginUser(@Valid @RequestBody User newUser) {
        User user = userRepository.findUserByUserName(userName);

        if (user != null && userName.equals(user.getUserName())) {
            return Status.SUCCESS;
        } else
            return Status.FAILURE;
    }

}
