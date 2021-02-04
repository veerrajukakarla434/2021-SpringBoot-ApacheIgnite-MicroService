package com.vkakarla.springboot.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vkakarla.springboot.ignite.model.Person;
import com.vkakarla.springboot.ignite.serviceImpl.PersonService;


@RestController
public class PersonController {
	
	@Autowired
    PersonService personService;
	
	@GetMapping("/api/persons")
    public ResponseEntity<Object> getPersons() {
        return new ResponseEntity<>(personService.getPerons(),HttpStatus.OK);
    }

    @PostMapping("/api/savePersons")
    public ResponseEntity<Object> savePersons(@RequestBody Person person) {
    	personService.savePerson(person);
         return new ResponseEntity<>("Person Data Saved Successfully",HttpStatus.OK);
    }
    
	 
}
