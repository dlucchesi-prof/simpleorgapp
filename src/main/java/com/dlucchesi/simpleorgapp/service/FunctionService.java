package com.dlucchesi.simpleorgapp.service;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.FunctionImp;

import java.util.List;
import java.util.Optional;

public interface FunctionService {
    Function create();

    FunctionImp validateInstance(Function function);

    Optional<Function> save(Function function);

    List<Function> listByUser(User user);

    com.dlucchesi.simpleorgapp.repository.FunctionImpRepository getFunctionImpRepository();
}
