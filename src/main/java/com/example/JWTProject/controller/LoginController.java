package com.example.JWTProject.controller;


import com.example.JWTProject.model.AuthResponse;
import com.example.JWTProject.model.User;
import com.example.JWTProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public AuthResponse login(@RequestBody User user){
        return userService.verify(user);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.println("addUser");
        return userService.addUser(user);
    }
    @GetMapping("/testjwtprivate")
    public String testJwtPrivate(){
        return "testJwtPrivate passed (private)";
    }


}
