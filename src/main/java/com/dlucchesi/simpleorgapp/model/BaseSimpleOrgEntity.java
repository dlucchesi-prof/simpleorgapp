package com.dlucchesi.simpleorgapp.model;

public interface BaseSimpleOrgEntity {
    Long getId();

    Boolean getIsDeleted();

    Boolean getIsActive();

    void setId(Long id);

    void setIsDeleted(Boolean isDeleted);

    void setIsActive(Boolean isActive);

    boolean canEqual(Object baseSImpleOrgEntityImp);
}
