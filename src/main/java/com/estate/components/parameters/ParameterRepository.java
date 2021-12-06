package com.estate.components.parameters;

import com.estate.assets.models.Parameter;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jehad on 12/6/2021.
 */
public interface ParameterRepository extends CrudRepository <Parameter , String >{
    public Parameter findByKey(String key) ;

}
