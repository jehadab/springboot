package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jehad on 12/2/2021.
 */
@RestController
public class EstateController {

    @Autowired
    private EstateService estateService;


    @PostMapping("estate/add")
    public void addEstate(@RequestBody EstateModel estate){
        estateService.addEstate(estate);
    }

    @RequestMapping("estate")
    public List<EstateModel> getEstates(){

        return estateService.getEstates();
    }

    @GetMapping("/estate/{name}")
    public EstateModel getEstate(@PathVariable String name)
    {
        return estateService.getEstate(name);
    }

}
