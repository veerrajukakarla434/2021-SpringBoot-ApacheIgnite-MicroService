package com.vkakarla.springboot.ignite.repository;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.Query;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

import com.vkakarla.springboot.ignite.model.Person;

@RepositoryConfig(cacheName = "PersonCache")
@Repository
public interface PersonRepository extends IgniteRepository<Person, Long> {
    /**
     * Gets all the persons with the given name.
     * @param name Person name.
     * @return A list of Persons with the given first name.
     */
	/*
	 * @Query("SELECT * FROM Person p WHERE p.firstName = ?") public List<Person>
	 * findByFirstName(String firstName);
	 */
    /**
     * Returns top Person with the specified surname.
     * @param name Person surname.
     * @return Person that satisfy the query.
     */
   // public Cache.Entry<Long, Person> findTopByLastNameLike(String name);

}
