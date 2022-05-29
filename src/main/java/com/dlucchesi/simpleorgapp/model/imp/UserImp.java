package com.dlucchesi.simpleorgapp.model.imp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "user")
@Table(name = "tb_user")
public class UserImp implements com.dlucchesi.simpleorgapp.model.User {

    public Long id;
    private String login;
    private String passwd;

}
