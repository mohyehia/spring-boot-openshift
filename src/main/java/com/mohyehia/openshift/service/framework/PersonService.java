package com.mohyehia.openshift.service.framework;

import com.mohyehia.openshift.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person save(Person person);

    Person findById(int id);
}
