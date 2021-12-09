package com.estate.components.home;

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
    @GetMapping
    public String getHomeController(Model model) {
        ModelAndView view = new ModelAndView();

        return "index";


    }
}
