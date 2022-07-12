package com.dlucchesi.simpleorgapp.controller.imp;

import com.dlucchesi.simpleorgapp.facade.FunctionFacade;
import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/function")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class FunctionControllerImp implements com.dlucchesi.simpleorgapp.controller.FunctionController {

    private final FunctionFacade    functionFacade;

    @Override
    @PostMapping("/user")
    public List<Function> getByUser(User user){
        return functionFacade.getByUser(user);
    }

    @Override
    @GetMapping("/user/{id}")
    public List<Function> getByUserId(@PathVariable Long id){
        return functionFacade.getByUserId(id);
    }
}
