package com.mohyehia.openshift.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String country;
    private String city;
    private String state;
    private String buildingNumber;
}
