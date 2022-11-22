package com.example.springtest.controllers;

import com.example.springtest.entities.User;
import com.example.springtest.pojos.UserDto;
import com.example.springtest.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> userSignUp(@RequestBody UserDto userDto) {
        userService.userSignUp(userDto);
        return new ResponseEntity<>("Sign up successful!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String UserLogin(@ModelAttribute("user") User user) {
        User oauthUser = userService.userLogin(user.getEmail(), user.getPassword());
        if(Objects.nonNull(oauthUser)) {
            return "redirect:/landing";
        } else {
            return "redirect:/signup";
        }
    }


}
