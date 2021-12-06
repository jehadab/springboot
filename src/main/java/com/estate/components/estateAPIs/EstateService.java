package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jehad on 12/2/2021.
 */
@Service
public class EstateService {




    @Autowired
    private EstateRepository estaterepositories ;


    public void addEstate(EstateModel estate){
        estaterepositories.save(estate);

    }
    public List<EstateModel> getEstates(){
        List <EstateModel> list = new ArrayList<EstateModel>();
        estaterepositories.findAll().forEach(list::add);
        return list;
    }
    public EstateModel getEstate(String name ){
        return estaterepositories.findByName(name);
    }
}
