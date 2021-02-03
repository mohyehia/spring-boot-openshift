package com.mohyehia.openshift.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String job;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
}
