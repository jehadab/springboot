package com.estate.assets.models;

import javax.persistence.*;

/**
 * Created by Jehad on 12/2/2021.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public User(){

    }
    public User (long id, String name, String password){
        super();
        this.id = id ;
        this.name = name;
        this.password = password;
    }
    public User(String name, String password){
        this.name = name;
        this.password = password;

    }
}
