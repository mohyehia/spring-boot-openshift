package com.mohyehia.openshift.controller;

import com.github.javafaker.Faker;
import com.mohyehia.openshift.entity.Person;
import com.mohyehia.openshift.service.framework.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@Log4j2
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        log.info("PersonController :: findAll :: start");
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/load")
    public ResponseEntity<String> loadPersonsToDb() {
        log.info("PersonController :: loadPersonsToDb :: start");
        Faker faker = new Faker();
        Person person;
        for (int i = 0; i < 20; i++) {
            person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setJob(faker.job().title());
            person.setAddress(faker.address().fullAddress());
            personService.save(person);
        }
        log.info("New persons saved successfully!");
        return new ResponseEntity<>("New persons loaded Successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        log.info("PersonController :: savePerson :: start");
        person = personService.save(person);
        if (person == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("PersonController :: savePerson :: end");
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> retrievePerson(@PathVariable("id") int id) {
        log.info("PersonController :: retrievePerson :: start");
        Person person = personService.findById(id);
        if (person == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        log.info("PersonController :: retrievePerson :: end");
        return new ResponseEntity<>(person, HttpStatus.FOUND);
    }
}
