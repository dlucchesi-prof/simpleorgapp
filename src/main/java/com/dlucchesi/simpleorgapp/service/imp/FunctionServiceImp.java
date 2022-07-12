package com.dlucchesi.simpleorgapp.service.imp;

import com.dlucchesi.simpleorgapp.model.Function;
import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.FunctionImp;
import com.dlucchesi.simpleorgapp.repository.FunctionImpRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service("functionService")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter
public class FunctionServiceImp implements com.dlucchesi.simpleorgapp.service.FunctionService {

    private final FunctionImpRepository functionImpRepository;

    @Override
    public Function create(){
        return (Function) new FunctionImp();
    }

    @Override
    public FunctionImp validateInstance(Function function){
        if (function instanceof FunctionImp){
            return (FunctionImp) function;
        }
        return null;
    }

    @Override
    public Optional<Function> save(Function function){
        if (validate(function)){
            FunctionImp toDb = validateInstance(function);
            FunctionImp fromDb = functionImpRepository.save(toDb);
            if (!isNull(fromDb)){
                log.info("Saved : ", fromDb);
                return Optional.of(fromDb);
            } else {
                log.error("Not saved : ", toDb);
            }
        } else {
            log.error("Invalid function!", function);
        }
        return Optional.empty();
    }

    private Boolean validate(Function function) {
        Boolean ret = Boolean.FALSE;
        if (!isNull(function)){
            FunctionImp f = validateInstance(function);
            if (!isNull(f)){
                if (!isNull(f.getLabel()) && f.getLabel().trim().length() > 0){
                    if (!isNull(f.getOrder()) && f.getOrder().compareTo(0) > 0){
                        ret = Boolean.TRUE;
                    } else {
                        log.warn("Function order empty or <= 0: {}", f);
                    }
                } else {
                    log.warn("Function label empty: {}", f);
                }
            } else {
                log.error("Wrong object instance Function: {}", function.getClass().toString());
            }
        } else {
            log.warn("Function empty!");
        }
        return ret;
    }

    @Override
    public List<Function> listByUser(User user){
        List<Function> ret = new ArrayList<>();
        if (!isNull(user)) {
            List<FunctionImp> lst = functionImpRepository.findByUser(user);
            ret.addAll(lst.stream().toList());
        }
        return ret;
    }

}
