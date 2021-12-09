package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jehad on 12/2/2021.
 */

public interface EstateRepository extends CrudRepository<EstateModel , String> {
    public EstateModel findByName(String name);
    public EstateModel findById(Long id);
    public List<EstateModel> findBySoldPriceAndBuyerNameIsNull(double notSold);
    public void deleteById(Long id);



}
