package com.dlucchesi.simpleorgapp.service;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.UserImp;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getByLogin(String login);

    Optional<User> getById(Long id);

    List<User> list();

    Optional<User> save(User user);

    Boolean logicalDelete(User user);

    User create();

    Boolean validate(User user);

    Integer getPassLength();

    com.dlucchesi.simpleorgapp.repository.UserImpRepository getUserImpRepository();

    void maskUserPass(User user);
}
