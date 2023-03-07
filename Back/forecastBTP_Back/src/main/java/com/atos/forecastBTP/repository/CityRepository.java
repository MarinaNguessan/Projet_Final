package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.forecastBTP.models.City;

@Repository

public interface CityRepository extends CrudRepository <City, Long>{
    
}
