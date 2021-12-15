package com.estate.components.estateAPIs;

import brave.Span;
import brave.Tracer;
import com.estate.AOP.AopLogger;
import com.estate.assets.dbrepository.EstateLogRepository;
import com.estate.assets.models.EstateLog;
import com.estate.assets.models.EstateModel;
import com.estate.components.parameters.ParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private EstateLogRepository estateLogRepository;

    private Tracer tracer;

    public EstateService(Tracer tracer) {
        this.tracer = tracer;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(EstateService.class);


    @AopLogger
    public EstateModel addEstate(EstateModel estate){


        estaterepositories.save(estate);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        String traceId= tracer.currentSpan().context().traceIdString();
        estateLogRepository.save(new EstateLog(traceId , userName , new Date() , estate ));

//        LOGGER.info("for estate name {} price {} stocks {}" ,
//                estate.getName(), estate.getPrice(), estate.getStocksNumber());
        return estate;
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

    @AopLogger
    public EstateModel updateState(Long id , String name , Long price){

        EstateModel estate = estaterepositories.findById(id);
        estate.setName(name);
        estate.setPrice(price);
        estaterepositories.save(estate);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        String traceId= tracer.currentSpan().context().traceIdString();
        EstateLog estateLog = new EstateLog();
        estateLog.updateEstateLog(traceId , userName , new Date() , estate );
        estateLogRepository.save(estateLog);
        return estate;


    }
    public EstateModel initSelling(String id){
        EstateModel selectedEstate= getEstateById(id);
        selectedEstate.setSoldPrice(selectedEstate.getPrice() * getProfitRatio());

        return selectedEstate;

    }

    @AopLogger
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EstateModel sellState(EstateModel estate){
        try {
            estate.setSellingDate(new Date());
            estaterepositories.save(estate);

//            LOGGER.info(" a sell action on state with id {} : \n estate value : {} \n estate sold price : {}",
//                    estate.getId() , estate.getPrice() , estate.getSoldPrice());

        }catch (ObjectOptimisticLockingFailureException e)
        {
            System.out.println("Somebody has already sold the state in concurrent transaction. Will try again...");
        }
        return estate;
    }

    @AopLogger
    public String deleteEstate(String id){


        estateLogRepository.deleteAllByEstate(estaterepositories.findById(Long.parseLong(id)));
        estaterepositories.deleteById(Long.parseLong(id));

//        LOGGER.info("a delete id {} : ",id );

        return id;
    }
    public int getStocksNumber(){

        return parameterService.getStocks();

    }
    public float getProfitRatio(){
        return parameterService.getProfitRatio();
    }
    public List<EstateLog> getAllEstateLogs(String id ){
        EstateModel estate = estaterepositories.findById(Long.parseLong(id));
        List<EstateLog> logs = estateLogRepository.findByEstate(estate);
        return logs;

    }

}