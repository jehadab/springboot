package com.estate.components.estateAPIs;

import com.estate.assets.models.EstateModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jehad on 12/2/2021.
 */

public interface EstateRepository extends CrudRepository<EstateModel , String> {
    public EstateModel findByName(String name);


}
