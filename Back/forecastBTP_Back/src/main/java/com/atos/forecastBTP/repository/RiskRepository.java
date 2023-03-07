package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atos.forecastBTP.models.Risk;


@Repository
public interface RiskRepository extends CrudRepository <Risk, Long> {
    
}
