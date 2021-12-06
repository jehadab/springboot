package com.estate.initializer.security;

import com.estate.assets.models.User;
import com.estate.components.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by Jehad on 12/4/2021.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;
        try{
            user = userService.findUserByName(name);
            
        }
        catch (UsernameNotFoundException err)
        {
            new UsernameNotFoundException(String.format("User with email=%s was not found", name));
        }
         return new CurrentUser(user);
        //todo change try catch to orelsethrow


    }
}
