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

import com.atos.forecastBTP.models.Risk;
import com.atos.forecastBTP.repository.RiskRepository;

@RestController
@RequestMapping("/api/risks")
public class RiskController {
    @Autowired

    private RiskRepository riskRepository;

    @GetMapping()
    public List<Risk>findAll(){
        return (List<Risk>)riskRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Risk> findById(@PathVariable(value = "id") long id) {
    var risk = riskRepository.findById(id);

    if (risk.isPresent()) {
      return ResponseEntity.ok().body(risk.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<Risk> save(@Validated @RequestBody Risk risk) {

    return new ResponseEntity<>(riskRepository.save(risk), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<Risk> update(@Validated @RequestBody Risk risk){
    return new ResponseEntity<>(riskRepository.save(risk), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody Risk risk){
    riskRepository.deleteById(risk.getId());
  }
    
}
