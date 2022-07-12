package com.dlucchesi.simpleorgapp.model;

public interface User extends BaseSimpleOrgEntity {

    String getLogin();

    String getPasswd();

    void setLogin(String login);

    void setPasswd(String passwd);
}
