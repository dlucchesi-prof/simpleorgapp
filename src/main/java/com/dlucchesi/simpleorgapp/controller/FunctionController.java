package com.dlucchesi.simpleorgapp.controller;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface FunctionController {
    @PostMapping("/user")
    List<Function> getByUser(User user);

    @PostMapping("/user/{id}")
    List<Function> getByUserId(@PathVariable Long id);
}
