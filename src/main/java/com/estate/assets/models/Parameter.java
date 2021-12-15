package com.estate.assets.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jehad on 12/2/2021.
 */


@Entity
@Table(name = "parameter")
public class Parameter implements Serializable {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "p_key")
    private String key ;
    @Column(name = "p_value")
    private String value ;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parameter() {

    }
    public Parameter(String key, String value) {
        super();

        this.key = key;
        this.value = value;
    }
    public Parameter(int id ,String key, String value){
        this.id = id;
        this.key = key;
        this.value = value;
    }



}
