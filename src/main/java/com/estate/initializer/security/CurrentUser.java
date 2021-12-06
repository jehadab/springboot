package com.estate.initializer.security;

import com.estate.assets.models.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Jehad on 12/4/2021.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User{

    private User user;

    public CurrentUser(User user) {
        super(user.getName(), user.getPassword() , AuthorityUtils.createAuthorityList("User"));

        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }
  }

