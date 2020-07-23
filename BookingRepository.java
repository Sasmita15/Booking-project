package com.sasmita.roombookingproject.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sasmita.roombookingproject.modal.Customer;
import com.sun.xml.bind.v2.model.core.ID;

@RepositoryRestResource
public interface BookingRepository extends CrudRepository<Customer, Integer>{

	Optional<Customer> findById(ID id);

}