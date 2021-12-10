package com.estate.components.parameters;

import com.estate.assets.models.EstateModel;
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
    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterService(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public List<Parameter> getAllParameters() {
        List<Parameter> result = new ArrayList<>();
        parameterRepository.findAll().forEach(result::add);
        return result;
    }

    public Parameter getParameter(String id) {
        return parameterRepository.findById(Integer.valueOf(id));
    }

    public void updateParameter(Parameter parameter) {
        parameterRepository.save(parameter);
    }

    public void addParameter(Parameter parameter) {
        parameterRepository.save(parameter);
    }

    public Parameter getParameterByKey(String key) {
        return parameterRepository.findByKey(key);

    }
    public void initializerChecker (){
        if(parameterRepository.findByKey("stocks") != null && parameterRepository.findByKey("profitRatio") != null){
            return ;
        }
         final Parameter stocks = new Parameter("stocks","5");
         final Parameter profitRatio = new Parameter("profitRatio","1");
         parameterRepository.save(stocks);
         parameterRepository.save(profitRatio);
         return ;


    }
    public int getStocks() {

        return Integer.parseInt(parameterRepository.findByKey("stocks").getValue());
    }
    public float getProfitRatio(){

        return Float.parseFloat((parameterRepository.findByKey("profitRatio").getValue()));
    }


}
