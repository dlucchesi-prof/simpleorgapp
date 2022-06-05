package com.dlucchesi.simpleorgapp.controller;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.UserImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {
    @GetMapping("/")
    List<User> list();

    @GetMapping("/login")
    User login(@RequestBody UserImp user);
}
