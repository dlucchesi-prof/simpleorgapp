package com.dlucchesi.simpleorgapp.facade.imp;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service("userFacade")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserFacadeImp implements com.dlucchesi.simpleorgapp.facade.UserFacade {

    protected final UserService userService;

    @Override
    public Optional<User> login(User user){
        Optional<User> ret = Optional.empty();
        if (!isNull(user)){
            Optional<User> optUser;
            if (!isNull(user.getId())){
                log.debug("Find by Id");
                optUser = userService.getById(user.getId());
            } else if (!isNull(user.getLogin()) && user.getLogin().trim().length() > 0){
                log.debug("Find by Login");
                optUser = userService.getByLogin(user.getLogin());
            } else {
                log.error("User doens't have Login or Id {}", user);
                throw new RuntimeException();
            }
            if (optUser.isPresent()){
                User dbUser = optUser.get();
                if (dbUser.getLogin().equals(user.getLogin())){
                    if (dbUser.getPasswd().equals(user.getPasswd())){
                        userService.maskUserPass(dbUser);
                        ret = Optional.of(dbUser);
                        log.debug("Login OK : {}", dbUser);
                    } else {
                        log.warn("Password not match!");
                    }
                } else {
                    log.error("User login empty: {}", user);
                }
            }
        }
        return ret;
    }
}
