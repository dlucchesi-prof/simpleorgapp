package com.dlucchesi.simpleorgapp.model.imp;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.UserHasFunction;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "user")
@Table(name = "tb_user", schema = "simpleorg")
@SequenceGenerator(name="un_seq", sequenceName="t_user_seq", allocationSize=1)
public class UserImp extends BaseSimpleOrgEntityImp implements com.dlucchesi.simpleorgapp.model.User {

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String passwd;
    @OneToMany(mappedBy = "user", targetEntity = FunctionImp.class)
    private Set<UserHasFunction> functions;

    @Override
    public boolean canEqual(Object userImp) {
        return (userImp instanceof User);
    }

    @Override
    public String toString() {
        return "UserImp{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwd='" + "*****" + '\'' +
                '}';
    }
}
