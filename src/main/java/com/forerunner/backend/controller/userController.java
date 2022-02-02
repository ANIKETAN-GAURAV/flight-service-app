package com.forerunner.backend.controller;

import com.forerunner.backend.Dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://stickynotesfrontend-339809.uc.r.appspot.com/")
@RestController
@RequestMapping("/api/v1/user")
public class userController {

    //get all notes
    @GetMapping("/{userName}")
    public User getAllStickyNotes(@PathVariable String userName) {
        List<User> stickyNotes = userRepository.findUserByUserName(userName);
        if (stickyNotes == null)
            return new ArrayList<>();

        return stickyNotes;
    }

}
