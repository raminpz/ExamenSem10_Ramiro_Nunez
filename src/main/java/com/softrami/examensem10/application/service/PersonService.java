package com.softrami.examensem10.application.service;

import com.softrami.examensem10.domain.model.Person;
import com.softrami.examensem10.domain.port.in.PersonUseCase;

import java.util.Optional;

public class PersonService implements PersonUseCase {

    private final PersonUseCase personUseCase;

    public PersonService(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @Override
    public Person crearPersona(Person person) {
        return personUseCase.crearPersona(person);
    }

    @Override
    public Optional<Person> getPersona(Long id) {
        return personUseCase.getPersona(id);
    }

    @Override
    public Optional<Person> updatePersona(Long id, Person person) {
        return personUseCase.updatePersona(id,person);
    }

    @Override
    public boolean deletePersona(Long id) {
        return personUseCase.deletePersona(id);
    }
}
