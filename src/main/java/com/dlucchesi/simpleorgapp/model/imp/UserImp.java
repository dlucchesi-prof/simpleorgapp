package com.dlucchesi.simpleorgapp.model.imp;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user")
@Table(name = "tb_user", schema = "simpleorg")
public class UserImp implements com.dlucchesi.simpleorgapp.model.User {

    @Id
    @GeneratedValue
    public Long id;
    @Column(nullable = false, unique = true)
    private String login;
    private String passwd;

    @Override
    public String toString() {
        return "UserImp{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwd='" + "*****" + '\'' +
                '}';
    }
}
