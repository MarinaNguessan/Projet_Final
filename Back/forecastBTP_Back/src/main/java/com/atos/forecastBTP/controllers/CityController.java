package com.atos.forecastBTP.controllers;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.forecastBTP.models.City;
import com.atos.forecastBTP.repository.CityRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping()
    public List<City>findAll(){
        return (List<City>)cityRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<City> findById(@PathVariable(value = "id") long id) {
    var city = cityRepository.findById(id);

    if (city.isPresent()) {
      return ResponseEntity.ok().body(city.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<City> save(@Validated @RequestBody City city) {

    return new ResponseEntity<>(cityRepository.save(city), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<City> update(@Validated @RequestBody City city){
    return new ResponseEntity<>(cityRepository.save(city), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody City city){
    cityRepository.deleteById(city.getId());
  }
  
    
}
