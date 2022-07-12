package com.dlucchesi.simpleorgapp.facade;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;

import java.util.List;

public interface FunctionFacade {
    List<Function> getByUser(User user);

    List<Function> getByUserId(Long userId);
}
