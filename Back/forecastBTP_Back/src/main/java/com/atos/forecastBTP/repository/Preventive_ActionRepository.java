package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atos.forecastBTP.models.Preventive_Action;

@Repository
public interface Preventive_ActionRepository extends CrudRepository <Preventive_Action, Long>{
    
}
