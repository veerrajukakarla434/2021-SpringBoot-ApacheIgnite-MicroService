package com.vkakarla.springboot.ignite.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.springboot.ignite.model.Person;
import com.vkakarla.springboot.ignite.repository.PersonRepository;
import com.vkakarla.springboot.ignite.service.IPersonService;

@Service
public class PersonService implements IPersonService {
  
	 @Autowired
	 PersonRepository personRepository;
	 
	 @Override
	 public void savePerson(Person person) {
		 personRepository.save(person.getId(), person);
		 
	 }
	 
	 @Override
	 public List<Person> getPerons(){
		 
		  System.out.println(personRepository.findAll());
		 
			  List<Person> pList = new ArrayList<>(); 
			  
			  for(Person p : personRepository.findAll()) {
				  pList.add(p);
			  }
			 
			return pList;
			
	 }
}
