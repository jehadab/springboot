package com.estate.components.parameters;

import com.estate.assets.models.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehad on 12/6/2021.
 */
@Service
public class ParameterService {
    private final ParameterRepository parameterRepository ;

    @Autowired
    public ParameterService (ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }
    public List<Parameter> getAllParameters() {
        List<Parameter> result = new ArrayList<>();
        parameterRepository.findAll().forEach(result::add);
        return result;
    }


}