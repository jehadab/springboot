package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import com.estate.assets.models.Parameter;
import com.estate.components.parameters.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jehad on 12/2/2021.
 */
@Service
@Transactional
public class EstateService {

    @Autowired
    private EstateRepository estaterepositories ;
    @Autowired
    private ParameterService parameterService;


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
    public EstateModel getEstateById(String id ){

        return estaterepositories.findById(Long.parseLong(id));

    }
    public List<EstateModel> getUnsoldEstates(){
        List <EstateModel> unsoldList = new ArrayList<EstateModel>();
        estaterepositories.findBySoldPriceAndBuyerNameIsNull(Double.parseDouble("0")).forEach(unsoldList::add);
//        this.estaterepositories.findBySoldPriceNotNull().forEach((x)->{
//            System.out.println(x.get);
//        });
        return unsoldList ;
    }
    public void updateState(Long id , String name , Long price){
        EstateModel estate = estaterepositories.findById(id);
        estate.setName(name);
        estate.setPrice(price);
        estaterepositories.save(estate);
    }
    public EstateModel initSelling(String id){
        EstateModel selectedEstate= getEstateById(id);
        selectedEstate.setSoldPrice(selectedEstate.getPrice() * getProfitRatio());

        return selectedEstate;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sellState(EstateModel estate){
        try {
            estate.setSellingDate(new Date());
            estaterepositories.save(estate);
        }catch (ObjectOptimisticLockingFailureException e)
        {
            System.out.println("Somebody has already sold the state in concurrent transaction. Will try again...");
        }
    }
    public void deleteEstate(String id){
        estaterepositories.deleteById(Long.parseLong(id));
    }
    public int getStocksNumber(){

        return parameterService.getStocks();

    }
    public float getProfitRatio(){
        return parameterService.getProfitRatio();
    }

}
