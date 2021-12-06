package com.estate.assets.dbrepository;

import com.estate.assets.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jehad on 12/2/2021.
 */
public interface UserRepository extends CrudRepository <User, String > {
    public User findByName(String name);
}
