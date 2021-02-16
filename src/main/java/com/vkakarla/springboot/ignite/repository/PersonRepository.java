package com.vkakarla.springboot.ignite.repository;

import java.util.List;

import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.Query;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.stereotype.Repository;

import com.vkakarla.springboot.ignite.model.Person;

@RepositoryConfig(cacheName = "Person")
@Repository
public interface PersonRepository extends IgniteRepository<Person, Long> {
	
}
