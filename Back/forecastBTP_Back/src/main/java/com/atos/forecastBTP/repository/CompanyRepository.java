package com.atos.forecastBTP.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.forecastBTP.models.Company;

@Repository
public interface CompanyRepository extends CrudRepository <Company, Long>{
    
}
