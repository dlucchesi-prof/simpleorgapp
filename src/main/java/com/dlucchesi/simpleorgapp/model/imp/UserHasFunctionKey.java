package com.dlucchesi.simpleorgapp.model.imp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserHasFunctionKey {

    @Column(name = "user_id")
    protected Long  userId;

    @Column(name = "function_id")
    protected Long  functionId;

}
