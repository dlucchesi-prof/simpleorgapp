package com.dlucchesi.simpleorgapp.service.imp;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.model.imp.UserImp;
import com.dlucchesi.simpleorgapp.repository.UserImpRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service("userService")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter
public class UserServiceImp implements com.dlucchesi.simpleorgapp.service.UserService {

    @Value("${simpleorgapp.security.passlength}")
    protected Integer   passLength;

    private final UserImpRepository   userImpRepository;

    @Override
    public Optional<User> getByLogin(String login){
        if (!isNull(login) && login.trim().length() > 0){
            UserImp byLogin = userImpRepository.findByLogin(login);
            if (byLogin != null){
                return Optional.of(byLogin);
            }
        } else {
            log.warn("Login empty!");
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getById(Long id){
        if (!isNull(id)){
            Optional<UserImp> byId = userImpRepository.findById(id);
            if (byId.isPresent()) {
                return Optional.of(byId.get());
            }
        } else {
            log.warn("Id empty!");
        }
        return Optional.empty();
    }

    @Override
    public List<User> list(){
        List<User> ret = new ArrayList<>();
        List<UserImp> lst = userImpRepository.findAll();
        lst.forEach(u -> u.setPasswd("*****"));
        ret.addAll(lst);
        return ret;
    }

    @Override
    public Optional<User> save(User user){
        if (validate(user)){
            UserImp toDb = validateInstance(user);
            UserImp fromDb = userImpRepository.save(toDb);
            if (!isNull(fromDb)){
                log.info("Saved : ", fromDb);
                return Optional.of(fromDb);
            } else {
                log.error("Not saved : ", toDb);
            }
        } else {
            log.error("Invalid user!", user);
        }
        return Optional.empty();
    }

    @Override
    public Boolean logicalDelete(User user){
        Boolean ret = Boolean.FALSE;
        if (!isNull(user)){
            user.setIsDeleted(true);
            user.setIsActive(false);
            Optional<User> fromDb = save(user);
            if (fromDb.isPresent()){
                ret = Boolean.TRUE;
            }
        }
        return ret;
    }

    @Override
    public User create(){
        return (User) new UserImp();
    }

    protected UserImp validateInstance(User user) {
        if (user instanceof UserImp){
            return (UserImp) user;
        }
        return null;
    }

    @Override
    public Boolean validate(User user) {
        Boolean ret = Boolean.FALSE;
        if (!isNull(user)){
            UserImp u = validateInstance(user);
            if (!isNull(u)) {
                if (!isNull(u.getLogin()) && u.getLogin().trim().length() > 0){
                    if (!isNull(u.getLogin()) && u.getLogin().trim().length() > 0){
                        if (u.getLogin().trim().length() >= passLength){
                            ret = Boolean.TRUE;
                        } else {
                            log.warn("User password can't be applied! : ", u);
                        }
                    } else {
                        log.warn("User password empty! : ", u);
                    }
                } else {
                    log.warn("User login empty! : ", u);
                }
            } else {
                log.error("Wrong object instance Function: {}", user.getClass().toString());
            }
        } else {
            log.warn("User empty!");
        }
        return ret;
    }


    @Override
    public void maskUserPass(User user){
        if (!isNull(user)){
            user.setPasswd("*****");
        }
    }
}
