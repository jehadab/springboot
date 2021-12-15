package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import com.estate.components.parameters.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Jehad on 12/2/2021.
 */
@Controller
public class EstateController {

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private EstateService estateService;

    @GetMapping("estate/add")
    public String addEstate(HttpServletRequest request, Model model)
    {
        EstateModel estate = new EstateModel();
        estate.setStocksNumber(estateService.getStocksNumber());

        model.addAttribute("estate" , estate);
        model.addAttribute("isdone" , request.getParameter("success"));
        return "/estate/add_estate";
    }
    @PostMapping("/estate/processForm")
    public String processForm(@ModelAttribute(value = "estate" )EstateModel estate
            , Model model , HttpServletRequest  request){
        estateService.addEstate(estate);
//        String refere = request.getHeader("Referer");
        request.setAttribute("isdone", "true");
        return "redirect:/estate/add?success=true";
    }
    @GetMapping("/un_sold_estates")
    public String unSoldEstates(Model model){
        model.addAttribute("estates" , estateService.getUnsoldEstates());
        model.addAttribute("selectedEstate" , new EstateModel());
        return "/estate/unsoldList";
    }

    @PostMapping(value = "/un_sold_estates", params = "action=delete")
    public String deleteEstates(@RequestParam(name = "selectedEstate")String id){
        estateService.deleteEstate(id);
        return "redirect:/un_sold_estates";
    }
    @PostMapping(value = "/un_sold_estates", params = "action=edit")
    public String editEstate(@RequestParam(name = "selectedEstate")String id , Model model){
        EstateModel  selectedEstate =  estateService.getEstateById(id);
        model.addAttribute("estate" , selectedEstate );
        return "/estate/editEstate";
    }
    @PostMapping(value = "/estate/edit")
    public String saveEditedEstate(@ModelAttribute(name = "estate")EstateModel estate ){
//        System.out.println(estate.getId() + estate.getName() + estate.getPrice());
        estateService.updateState(estate.getId() , estate.getName() , estate.getPrice());
        return "redirect:/un_sold_estates";
    }
    @PostMapping(value = "/un_sold_estates", params = "action=sell")
    public String sellEstate(@RequestParam(name = "selectedEstate")String id , Model model){

        EstateModel selectedEstate = estateService.initSelling(id);
        model.addAttribute("estate" , selectedEstate );
        return "/estate/sell";
    }
    @PostMapping(value = "/estate/sell")
    public String sellEstate(@ModelAttribute(name = "estate")EstateModel estate){
        estateService.sellState(estate);
        return "redirect:/un_sold_estates";
    }

    @GetMapping(value = "test-nginx")
    public void testNginx()
    {
        System.out.println(serverPort);
    }

//    @GetMapping(value = "/estate/edit_estate" )
//    public String editEstate(@RequestParam(name = "selectedEstate") String id , Model model , HttpServletRequest request){
//        System.out.println(id);
//        System.out.println("_____"+request.getAttribute("estate"));
//
//        return "/estate/editEstate";
//    }

//    @RequestMapping("estate")
//    public String getEstates(){
//
//        return "add_estate";
//    }
//    @GetMapping("/estate/{name}")
//    public EstateModel getEstate(@PathVariable String name)
//    {
//        return estateService.getEstate(name);
//    }
//
}
