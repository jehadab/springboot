package com.estate.components.user;


import org.springframework.lang.NonNull;

/**
 * Created by Jehad on 12/4/2021.
 */
public class UserCreateForm {


    @NonNull
    private String name = "";

    @NonNull
    private String password = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public UserCreateForm(){
        super();
    }
    public UserCreateForm(String name , String password){
        this.name = name;
        this.password = password;

    }
}
