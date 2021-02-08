package com.vkakarla.springboot.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vkakarla.springboot.ignite.model.Person;
import com.vkakarla.springboot.ignite.serviceImpl.PersonService;


@RestController
public class PersonController {
	
	@Autowired
    PersonService personService;
	
	@GetMapping("/api/getPersons")
    public ResponseEntity<Object> getPersons() {
        return new ResponseEntity<>(personService.getPerons(),HttpStatus.OK);
    }

    @PostMapping("/api/savePerson")
    public ResponseEntity<Object> savePersons(@RequestBody Person person) {
    	personService.savePerson(person);
         return new ResponseEntity<>("Person Data Saved Successfully",HttpStatus.OK);
    }
    
    @PutMapping("/api/updatePerson")
    public ResponseEntity<Object> updatePersons(@RequestBody Person person) {
    	Person personResponse = personService.updatePerons(person);
         return new ResponseEntity<>(personResponse,HttpStatus.OK);
    }
    
    @DeleteMapping("/api/deletePerson/{id}")
    public ResponseEntity<Object> deletePersons(@PathVariable Long id) {
    	 personService.deletePerons(id);
         return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
	 
}
