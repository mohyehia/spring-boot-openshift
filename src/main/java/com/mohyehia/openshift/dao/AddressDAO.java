package com.mohyehia.openshift.dao;

import com.mohyehia.openshift.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Integer> {
}
