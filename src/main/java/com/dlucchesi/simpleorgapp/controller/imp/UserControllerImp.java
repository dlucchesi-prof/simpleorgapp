package com.dlucchesi.simpleorgapp.controller.imp;

import com.dlucchesi.simpleorgapp.facade.UserFacade;
import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.UserImp;
import com.dlucchesi.simpleorgapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserControllerImp implements com.dlucchesi.simpleorgapp.controller.UserController {

    protected final UserService     userService;
    protected final UserFacade      userFacade;

    @Override
    @GetMapping("/")
    public List<User> list(){
        return userService.list();
    }

    @Override
    @PostMapping("/login")
    public User login(@RequestBody UserImp user){
        Optional<User> optUser = userFacade.login(user);
        return optUser.isPresent() ? optUser.get() : null;
    }
}
