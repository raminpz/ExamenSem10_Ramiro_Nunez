package com.softrami.examensem10.infraestructure.repository;

import com.softrami.examensem10.domain.model.Person;
import com.softrami.examensem10.domain.port.out.PersonRepositoryPort;
import com.softrami.examensem10.infraestructure.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonJpaRepositoryAdapter implements PersonRepositoryPort {

    private final PersonJpaRepository personJpaRepository;

    public PersonJpaRepositoryAdapter(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @Override
    public Person save(Person person) {
        PersonEntity personEntity = PersonEntity.fromDomainModel(person);
        PersonEntity savePersonEntity = personJpaRepository.save(personEntity);
        return savePersonEntity.toDomainModel();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personJpaRepository.findById(id)
                .map(PersonEntity::toDomainModel);
    }

    @Override
    public Optional<Person> update(Long id, Person person) {
        if (personJpaRepository.existsById(person.getId())){
            PersonEntity personEntity = PersonEntity.fromDomainModel(person);
            PersonEntity updatepersonEntity = personJpaRepository.save(personEntity);
            return Optional.of(updatepersonEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (personJpaRepository.existsById(id)){
            personJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
