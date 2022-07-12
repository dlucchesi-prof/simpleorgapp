package com.dlucchesi.simpleorgapp.model;

public interface UserHasFunction {
    com.dlucchesi.simpleorgapp.model.imp.UserHasFunctionKey getUserHasFunctionKey();

    User getUser();

    Function getFunction();

    void setUserHasFunctionKey(com.dlucchesi.simpleorgapp.model.imp.UserHasFunctionKey userHasFunctionKey);

    void setUser(User user);

    void setFunction(Function function);
}
