package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atos.forecastBTP.models.Site;

@Repository
public interface SiteRepository extends CrudRepository <Site, Long> {
    
}
