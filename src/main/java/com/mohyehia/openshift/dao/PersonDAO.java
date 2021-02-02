package com.mohyehia.openshift.dao;

import com.mohyehia.openshift.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDAO extends JpaRepository<Person, Integer> {

}
