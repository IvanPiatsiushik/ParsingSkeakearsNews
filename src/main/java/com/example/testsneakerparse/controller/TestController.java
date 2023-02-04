package com.example.testsneakerparse.controller;

import com.example.testsneakerparse.entity.UserInfo;
import com.example.testsneakerparse.service.U_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private U_Service service;
    @GetMapping("/welcome")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }
    @GetMapping("/all")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String all(){
        return "Here all product ";
    }

    @PostMapping("/new")
    public String addNewsUser(@RequestParam UserInfo userInfo){
        return service.addUser(userInfo);
    }
}
