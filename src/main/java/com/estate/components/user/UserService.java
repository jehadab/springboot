package com.estate.components.user;

import com.estate.assets.models.User;
import com.estate.assets.dbrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Jehad on 12/4/2021.
 */
@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRep) {
        this.userRepository = userRep;

    }
    public User findUserByName(String username){
        return userRepository.findByName(username);
    }


    public User create (User form)
    {
        User user = new User();
        user.setName(form.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        return userRepository.save(user);
    }

}
