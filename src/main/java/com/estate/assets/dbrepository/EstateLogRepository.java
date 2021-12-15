package com.estate.assets.dbrepository;

import com.estate.assets.models.EstateLog;
import com.estate.assets.models.EstateModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jehad on 12/15/2021.
 */
public interface EstateLogRepository extends CrudRepository<EstateLog , String> {
    public List<EstateLog> findByEstate(EstateModel estate);
    public void deleteAllByEstate(EstateModel estate);
}
