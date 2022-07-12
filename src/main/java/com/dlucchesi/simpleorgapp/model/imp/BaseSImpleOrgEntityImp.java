package com.dlucchesi.simpleorgapp.model.imp;

import com.dlucchesi.simpleorgapp.model.BaseSimpleOrgEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class BaseSimpleOrgEntityImp implements BaseSimpleOrgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="un_seq")
    @Column(nullable = false, unique = true, name = "id")
    protected Long  id;
    protected Boolean   isDeleted;
    protected Boolean   isActive;

    @Override
    public boolean canEqual(Object baseSimpleOrgEntityImp) {
        return (baseSimpleOrgEntityImp instanceof BaseSimpleOrgEntity);
    }
}
