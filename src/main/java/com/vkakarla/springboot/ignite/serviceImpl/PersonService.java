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
	public Person updatePerons(Person person) {
		return personRepository.save(person.getId(), person);
		
	}

	@Override
	public void deletePerons(Long id) {
		List<Long> list = new ArrayList<>();
		list.add(id);
		personRepository.deleteAllById(list);
		
	}

	@Override
	 public List<Person> getPerons(){
		 
		List<Person> plist = new ArrayList<>();
			  Iterable<Person>  pList = personRepository.findAll();
			  for(Person p : pList) {
				  plist.add(p);
			  }
			 
			return plist;
			
	 }
	
}
