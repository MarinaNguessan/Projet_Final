package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atos.forecastBTP.models.User;


@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    
}
