package com.dlucchesi.simpleorgapp.model.imp;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "function")
@Table(name = "tb_function", schema = "simpleorg")
@SequenceGenerator(name="un_seq", sequenceName="t_func_seq", allocationSize=1)
public class FunctionImp extends BaseSimpleOrgEntityImp implements Function {

    @Column(nullable = false)
    protected String  label;
    @Column(nullable = false, name = "intOrder")
    protected Integer order;
    @OneToMany(mappedBy = "function", targetEntity = UserImp.class)
    protected Set<User> users;
    @ManyToOne(targetEntity = FunctionImp.class)
    protected Function parent;
    @OneToMany(targetEntity = FunctionImp.class,mappedBy = "parent")
    protected List<Function>    functions;

    @Override
    public boolean canEqual(Object functionImp) {
        return (functionImp instanceof Function);
    }
}
