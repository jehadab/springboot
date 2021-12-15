package com.estate.components.home;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jehad on 12/6/2021.
 */
@Controller
@RequestMapping({"/","/index"})
public class HomeContoller {

    @Value("${server.port}")
    private int serverPort;

    @GetMapping
    public String getHomeController(Model model) {
        ModelAndView view = new ModelAndView();
        model.addAttribute("serverPort" ,serverPort);
        return "index";


    }
}
