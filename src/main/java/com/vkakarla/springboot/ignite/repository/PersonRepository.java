package com.vkakarla.springboot.ignite.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

import com.vkakarla.springboot.ignite.model.Person;

@RepositoryConfig(cacheName = "PersonCache")
@Repository
public interface PersonRepository extends IgniteRepository<Person, Long> {

}
