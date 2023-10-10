package com.softrami.examensem10.domain.port.out;

import com.softrami.examensem10.domain.model.Person;

import java.util.Optional;

public interface PersonRepositoryPort {

    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> update(Long id, Person person);
    boolean deleteById(Long id);
}
