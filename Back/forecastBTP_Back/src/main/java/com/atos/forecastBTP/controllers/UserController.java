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

import com.atos.forecastBTP.models.User;
import com.atos.forecastBTP.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired

    private UserRepository userRepository;
    @GetMapping()
    public List<User>findAll(){
        return (List<User>)userRepository.findAll();
    }

    @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable(value = "id") long id) {
    var user = userRepository.findById(id);

    if (user.isPresent()) {
      return ResponseEntity.ok().body(user.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping()
  public ResponseEntity<User> save(@Validated @RequestBody User user) {

    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
  }

  @DeleteMapping()
  public ResponseEntity<User> update(@Validated @RequestBody User user){
    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
  }

  @PutMapping()
  public void delete(@Validated @RequestBody User user){
    userRepository.deleteById(user.getId());
  }
    
}
