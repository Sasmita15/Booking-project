package com.sasmita.roombookingproject.service;

import java.util.List;
import java.util.Optional;

import com.sasmita.roombookingproject.modal.Customer;
import com.sun.xml.bind.v2.model.core.ID;

public interface BookingService {

	Customer saveCustomer(Customer customer);
	
	Optional<Customer> customerDetails(ID id);
	
}
