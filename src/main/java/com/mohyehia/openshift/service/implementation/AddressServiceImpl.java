package com.mohyehia.openshift.service.implementation;

import com.mohyehia.openshift.dao.AddressDAO;
import com.mohyehia.openshift.entity.Address;
import com.mohyehia.openshift.service.framework.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressDAO addressDAO;

    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @Override
    public Address save(Address address) {
        return addressDAO.save(address);
    }
}
