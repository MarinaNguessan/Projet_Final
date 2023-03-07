package com.atos.forecastBTP.controllers;

import java.util.List;

import org.apache.el.stream.Optional;
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

import com.atos.forecastBTP.models.Company;

import com.atos.forecastBTP.repository.CompanyRepository;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping()
    public List<Company>findAll(){
        return (List<Company>)companyRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<Company> findById(@PathVariable(value = "id") long id) {
    var company = companyRepository.findById(id);

    if (company.isPresent()) {
      return ResponseEntity.ok().body(company.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<Company> save(@Validated @RequestBody Company company) {

    return new ResponseEntity<>(companyRepository.save(company), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<Company> update(@Validated @RequestBody Company company){
    return new ResponseEntity<>(companyRepository.save(company), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody Company company){
    companyRepository.deleteById(company.getId());
  }
    
}
