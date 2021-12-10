package com.estate.components.parameters;

import com.estate.assets.models.EstateModel;
import com.estate.assets.models.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jehad on 12/6/2021.
 */
@RestController
public class ParameterController {
    @Autowired
    ParameterService parameterService;

    @Cacheable("parameters")
    @GetMapping("/parameter")
    public List<Parameter> getParameters() {
        return parameterService.getAllParameters();
    }

    @Cacheable("parameters")
    @PostMapping("parameter/add")
    public void addParameter(@RequestBody Parameter parameter){
        parameterService.addParameter(parameter);
    }

    @CacheEvict("parameters")
    @PutMapping("parameter/update")
    public void updateParameter(@RequestBody Parameter parameter){
        parameterService.updateParameter(parameter);
    }
}
