package com.atos.forecastBTP.controllers;

import java.util.List;

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

import com.atos.forecastBTP.models.Site;
import com.atos.forecastBTP.repository.SiteRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sites")
public class SiteController {
    @Autowired

    private SiteRepository siteRepository;

    @GetMapping()
    public List<Site>findAll(){
        return (List<Site>)siteRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Site> findById(@PathVariable(value = "id") long id) {
    var site = siteRepository.findById(id);

    if (site.isPresent()) {
      return ResponseEntity.ok().body(site.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping( "register")
  public ResponseEntity<Site> save(@Validated @RequestBody Site site) {

    return new ResponseEntity<>(siteRepository.save(site), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Site> update(@Validated @RequestBody Site site){
    return new ResponseEntity<>(siteRepository.save(site), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody Site site){
    siteRepository.deleteById(site.getId());
  }
    
}
