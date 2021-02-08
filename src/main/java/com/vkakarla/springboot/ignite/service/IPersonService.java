package com.vkakarla.springboot.ignite.service;

import java.util.List;

import com.vkakarla.springboot.ignite.model.Person;

public interface IPersonService {
	
	public void savePerson(Person person);

	public List<Person> getPerons();

	public Person updatePerons(Person person);

	public void deletePerons(Long id);

}
