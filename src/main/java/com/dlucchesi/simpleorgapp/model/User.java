package com.dlucchesi.simpleorgapp.model;

public interface User {
    Long getId();

    String getLogin();

    String getPasswd();

    void setId(Long id);

    void setLogin(String login);

    void setPasswd(String passwd);
}
