package com.atos.forecastBTP.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.forecastBTP.models.Period;
import com.atos.forecastBTP.repository.PeriodRepository;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    @Autowired
    private PeriodRepository periodRepository;

    @GetMapping()
    public List<Period>findAll(){
        return (List<Period>)periodRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Period> findById(@PathVariable(value = "id") long id) {
    var period = periodRepository.findById(id);

    if (period.isPresent()) {
      return ResponseEntity.ok().body(period.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<Period> save(@Validated @RequestBody Period period) {

    return new ResponseEntity<>(periodRepository.save(period), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<Period> update(@Validated @RequestBody Period period){
    return new ResponseEntity<>(periodRepository.save(period), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody Period period){
    periodRepository.deleteById(period.getId());
  }
    
}
