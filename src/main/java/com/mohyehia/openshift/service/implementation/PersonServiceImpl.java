package com.mohyehia.openshift.service.implementation;

import com.mohyehia.openshift.dao.PersonDAO;
import com.mohyehia.openshift.entity.Person;
import com.mohyehia.openshift.service.framework.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public Person save(Person person) {
        return personDAO.save(person);
    }

    @Override
    public Person findById(int id) {
        return personDAO.findById(id).orElse(null);
    }
}
