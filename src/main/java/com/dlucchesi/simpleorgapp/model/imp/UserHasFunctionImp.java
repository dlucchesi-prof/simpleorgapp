package com.dlucchesi.simpleorgapp.model.imp;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "userHasFunction")
@Table(name = "tb_function", schema = "simpleorg")
@SequenceGenerator(name="un_seq", sequenceName="t_func_seq", allocationSize=1)
public class UserHasFunctionImp implements com.dlucchesi.simpleorgapp.model.UserHasFunction {

    @EmbeddedId
    private UserHasFunctionKey  userHasFunctionKey;

    @ManyToOne(targetEntity = UserImp.class)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User    user;

    @ManyToOne(targetEntity = FunctionImp.class)
    @MapsId("functionId")
    @JoinColumn(name = "function_id")
    Function    function;
}
