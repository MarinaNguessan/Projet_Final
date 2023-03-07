package com.atos.forecastBTP.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.atos.forecastBTP.models.Period;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Long> {

}
