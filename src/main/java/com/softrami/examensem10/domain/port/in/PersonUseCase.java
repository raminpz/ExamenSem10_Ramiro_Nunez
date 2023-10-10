package com.softrami.examensem10.domain.port.in;

import com.softrami.examensem10.domain.model.Person;

import java.util.Optional;

public interface PersonUseCase {
    Person crearPersona(Person persons);
    Optional<Person> getPersona(Long id);
    Optional<Person> updatePersona(Long id, Person persons);
    boolean deletePersona(Long id);
}
