package com.dlucchesi.simpleorgapp.facade;

import com.dlucchesi.simpleorgapp.model.User;

import java.util.Optional;

public interface UserFacade {
    Optional<User> login(User user);
}
