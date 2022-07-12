package com.dlucchesi.simpleorgapp.model;

public interface Function extends BaseSimpleOrgEntity {
    String getLabel();

    Integer getOrder();

    void setLabel(String label);

    void setOrder(Integer order);

    Function getParent();

    java.util.List<Function> getFunctions();

    void setParent(Function parent);

    void setFunctions(java.util.List<Function> functions);

    java.util.Set<User> getUsers();

    void setUsers(java.util.Set<User> users);
}
