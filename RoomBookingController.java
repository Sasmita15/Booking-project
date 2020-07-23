package com.sasmita.roombookingproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sasmita.roombookingproject.modal.Customer;
import com.sasmita.roombookingproject.service.BookingService;
import com.sun.xml.bind.v2.model.core.ID;

@RestController
@RequestMapping("/api")
public class RoomBookingController {

	private BookingService bookingService;

	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity createCustomerRecord(@RequestBody Customer customer) {
		
		bookingService.saveCustomer(customer);
		return new ResponseEntity("Customer record saved successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Customer>> listOfAllCustomer(@PathVariable ID id)
	{
		Optional<Customer> customerRecord = bookingService.customerDetails(id);
		if (customerRecord.empty() == null) {
			return new ResponseEntity("Customer record is not available",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Optional<Customer>>(customerRecord, HttpStatus.OK);
	}
	
	
	
}

