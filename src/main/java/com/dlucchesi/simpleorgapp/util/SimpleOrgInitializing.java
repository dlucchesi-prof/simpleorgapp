package com.dlucchesi.simpleorgapp.util;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleOrgInitializing implements InitializingBean {

    @Value("${simpleorgapp.security.defAdmin}")
    private String adminUser;
    @Value("${simpleorgapp.security.defPass}")
    private String adminPass;

    private final Environment   environment;
    private final UserService   userService;

    @Override
    public void afterPropertiesSet() {
        Optional<User> optUser = userService.getByLogin(adminUser);
        if (optUser.isEmpty()){
            User usrAdmin = userService.create();
            usrAdmin.setLogin(adminUser);
            usrAdmin.setPasswd(adminPass);
            Optional<User> usrRet = userService.save(usrAdmin);
            if (usrRet.isPresent()){
                log.warn("User admin created with: Login:{} Pass:{}", adminUser, adminPass);
            } else {
                log.error(MarkerFactory.getMarker("IMPORTANT"),"ERROR creating admin user!!!");
            }
        } else {
            log.info("Admin user already set");
        }
    }
}
