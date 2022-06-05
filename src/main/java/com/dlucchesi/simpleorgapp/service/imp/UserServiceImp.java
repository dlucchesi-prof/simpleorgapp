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
    public User create(){
        return (User) new UserImp();
    }

    @Override
    public UserImp validateInstance(User user) {
        if (user instanceof UserImp){
            return (UserImp) user;
        }
        return null;
    }

    @Override
    public Boolean validate(User user) {
        Boolean ret = Boolean.FALSE;
        if (!isNull(user)){
            if (!isNull(user.getLogin()) && user.getLogin().trim().length() > 0){
                if (!isNull(user.getLogin()) && user.getLogin().trim().length() > 0){
                    if (user.getLogin().trim().length() >= passLength){
                        ret = Boolean.TRUE;
                    } else {
                        log.warn("User password can't be applied! : ", user);
                    }
                } else {
                    log.warn("User password empty! : ", user);
                }
            } else {
                log.warn("User login empty! : ", user);
            }
        } else {
            log.warn("User null!");
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
