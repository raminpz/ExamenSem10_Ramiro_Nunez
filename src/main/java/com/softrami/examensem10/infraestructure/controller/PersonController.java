package com.softrami.examensem10.infraestructure.controller;

import com.softrami.examensem10.application.service.PersonService;
import com.softrami.examensem10.domain.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person createPersona = personService.crearPersona(person);

        return new ResponseEntity<>(createPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{personaId}")
    public ResponseEntity<Person> getPerson(@PathVariable Long personId){
        return personService.getPersona(personId)
                .map(person -> new ResponseEntity<>(person,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{personaId}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long personaId, @RequestBody Person person){
        return personService.updatePersona(personaId,person)
                .map(p -> new ResponseEntity<>(p,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{personaId}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long personaId){
        if (personService.deletePersona(personaId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
