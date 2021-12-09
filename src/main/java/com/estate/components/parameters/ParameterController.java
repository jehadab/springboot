package com.estate.components.parameters;

import com.estate.assets.models.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jehad on 12/6/2021.
 */
@Controller
public class ParameterController {
    @Autowired
    ParameterService parameterService;
    @GetMapping("/parameters/all")
    public String getParameters(Model model) {
        model.addAttribute("parameters" , parameterService.getAllParameters());
        return "/parameter/parameters";
    }
//    @PostMapping("/parameters/all")
//    public String editParameter(@ModelAttribute(name ="parameter")Parameter parameter ){
//        parameterService.updateParameter(parameter);
//        return "redirect:/parameters/all";
//    }
    @GetMapping("/parameter/add")
    public String addParameter(Model model){
        model.addAttribute("parameter" , new Parameter());
        return "/parameter/add";
    }
    @PostMapping(value = "/parameter/add")
    public String addParameter(@ModelAttribute(name ="parameter")Parameter parameter){
        parameterService.addParameter(parameter);
        return "redirect:/parameters/all";
    }
    @PostMapping(value = "/parameter/all", params = "action=edit")
    public String editParameter(@RequestParam(name = "parameterId")String id, Model model){
        model.addAttribute("parameter" , parameterService.getParameter(id));
        return "/parameter/edit";
    }
    @PostMapping(value = "/parameter/edit")
    public String saveEditedParameter(@ModelAttribute(name ="parameter") Parameter parameter )
    {
        parameterService.updateParameter(parameter);
        return "redirect:/parameters/all";
    }
//    @PostMapping
//    public void
}
