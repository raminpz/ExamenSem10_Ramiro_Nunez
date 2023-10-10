package com.softrami.examensem10.application.useCase;

import com.softrami.examensem10.domain.model.Person;
import com.softrami.examensem10.domain.port.in.PersonUseCase;
import com.softrami.examensem10.domain.port.out.PersonRepositoryPort;

import java.util.Optional;

public class PersonUseCaseImpl implements PersonUseCase {

    private final PersonRepositoryPort personRepositoryPort;

    public PersonUseCaseImpl(PersonRepositoryPort personRepositoryPort) {
        this.personRepositoryPort = personRepositoryPort;
    }

    @Override
    public Person crearPersona(Person person) {
        return personRepositoryPort.save(person);
    }

    @Override
    public Optional<Person> getPersona(Long id) {
        return personRepositoryPort.findById(id);
    }

    @Override
    public Optional<Person> updatePersona(Long id, Person person) {
        return personRepositoryPort.update(id, person);
    }

    @Override
    public boolean deletePersona(Long id) {
        return personRepositoryPort.deleteById(id);
    }
}
