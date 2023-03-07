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

import com.atos.forecastBTP.models.Preventive_Action;
import com.atos.forecastBTP.repository.Preventive_ActionRepository;

@RestController
@RequestMapping("/api/preventives")
public class Preventive_ActionController {

    @Autowired

    private Preventive_ActionRepository preventive_actionRepository;

    @GetMapping()
    public List<Preventive_Action>findAll(){
        return (List<Preventive_Action>)preventive_actionRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Preventive_Action> findById(@PathVariable(value = "id") long id) {
    var preventive_action = preventive_actionRepository.findById(id);

    if (Preventive_Action.isPresent()) {
      return ResponseEntity.ok().body(preventive_action.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<Preventive_Action> save(@Validated @RequestBody Preventive_Action preventive_action) {

    return new ResponseEntity<>(preventive_actionRepository.save(preventive_action), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<Preventive_Action> update(@Validated @RequestBody Preventive_Action preventive_action){
    return new ResponseEntity<>(preventive_actionRepository.save(preventive_action), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody Preventive_Action preventive_action){
    preventive_actionRepository.deleteById(preventive_action.getId());
  }
    
}
