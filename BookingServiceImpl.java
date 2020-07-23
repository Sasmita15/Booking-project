package com.sasmita.roombookingproject.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasmita.roombookingproject.modal.Customer;
import com.sasmita.roombookingproject.repo.BookingRepository;
import com.sun.xml.bind.v2.model.core.ID;

@Service
public class BookingServiceImpl implements BookingService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookingRepository bookingRepository;
	
	public void setBookingRepository(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		logger.debug("saveCustomer called");
        return bookingRepository.save(customer);	
	}

	@Override
	public Optional<Customer> customerDetails(ID id) {
		logger.debug("listAllCustomers called");
        return  bookingRepository.findById(id);
	}

}
