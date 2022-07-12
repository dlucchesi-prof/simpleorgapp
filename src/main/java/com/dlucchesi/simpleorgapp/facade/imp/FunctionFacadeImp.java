package com.dlucchesi.simpleorgapp.facade.imp;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.service.FunctionService;
import com.dlucchesi.simpleorgapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("functionFacade")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class FunctionFacadeImp implements com.dlucchesi.simpleorgapp.facade.FunctionFacade {

    protected final FunctionService functionService;
    protected final UserService userService;

    @Override
    public List<Function> getByUser(User user){
        List<Function> ret = new ArrayList<>();
        Optional<User> optUser = userService.getById(user.getId());
        if (optUser.isPresent()){
            User usrFromDb = optUser.get();

            ret.addAll(functionService.listByUser(usrFromDb).stream()
                    .filter(f -> !f.getIsDeleted())
                    .collect(Collectors.toList()));
        }
        return ret;
    }

    @Override
    public List<Function> getByUserId(Long userId){
        List<Function> ret = new ArrayList<>();
        Optional<User> optUser = userService.getById(userId);
        if (optUser.isPresent()){
            User usrFromDb = optUser.get();

            ret.addAll(functionService.listByUser(usrFromDb).stream()
                    .filter(f -> !f.getIsDeleted())
                    .collect(Collectors.toList()));
        }
        return ret;
    }

}
