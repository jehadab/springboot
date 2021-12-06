package com.estate.components.parameters;

import com.estate.assets.models.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jehad on 12/6/2021.
 */
@RestController
public class ParameterController {
    @Autowired
    ParameterService parameterService;
    @GetMapping("/parameter")
    public List<Parameter> getParameters() {
        return parameterService.getAllParameters();
    }
}
