package com.estate.initializer;

import com.estate.assets.models.Parameter;
import com.estate.assets.models.User;
import com.estate.assets.dbrepository.ParametersRepository;
import com.estate.components.parameters.ParameterService;
import com.estate.components.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Jehad on 12/2/2021.
 */
@Configuration
public class StartupInitilaizer {
    @Autowired
    private UserService userService;
    @Autowired
    private ParameterService parameterService;
    @PostConstruct
    public void init() {
        parameterService.initializerChecker();

//        createUsers();

    }
    private void createUsers(){
        userService.create(new User("user1","123"));
        userService.create(new User("user2","123"));
        userService.create(new User("user3","1234"));
    }
}
