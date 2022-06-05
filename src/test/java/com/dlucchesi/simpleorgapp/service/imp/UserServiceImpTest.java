package com.dlucchesi.simpleorgapp.service.imp;

import com.dlucchesi.simpleorgapp.model.User;
import com.dlucchesi.simpleorgapp.repository.UserImpRepository;
import com.dlucchesi.simpleorgapp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceImpTest {

//    @TestConfiguration
//    static class UserServiceImpTestContextConfiguration {
//
//        @Bean
//        public UserService userService() {
//            return new UserServiceImp();
//        }
//    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserImpRepository userImpRepository;

    @Test
    public void saveUserOk() {
        User user = userService.create();
        user.setLogin("dlucchesi@gmail.com");
        user.setPasswd("12345");
        Optional<User> fromDb = userService.save(user);
        assertTrue(fromDb.isPresent());
        assertNotNull(fromDb.get().getId());
    }
}
