package com.sasmita.testroombookingproject;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import com.sasmita.roombookingproject.modal.Customer;
import com.sasmita.roombookingproject.repo.BookingRepository;
import com.sasmita.roombookingproject.service.BookingService;
import com.sun.xml.bind.v2.model.core.ID;

@RunWith(MockitoJUnitRunner.class)
public class BookingProjectTests {
     
    @InjectMocks
    BookingService manager;
     
    @Mock
    BookingRepository dao;
 
    @Before(value = "")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllCustomerTest()
    {
        List<Customer> list = new ArrayList<Customer>();
        Customer bookingOne = new Customer(1, "Sasmita", "Swain", "bookuser1@gmail.com", "user1@123");
        Customer bookingTwo = new Customer(2, "Ankita", "Dhal", "bookuser2@gmail.com", "user2@123");
        Customer bookingThree = new Customer(3, "Sai", "ram", "bookuser3@gmail.com", "user3@123");
         
        list.add(bookingOne);
        list.add(bookingTwo);
        list.add(bookingThree);
         
        Mockito.when(dao.findAll()).thenReturn(list);
         
        ID id;
        Optional<Customer> empList = manager.customerDetails(id);
         
        assertEquals(3, empList.equals(id));
        verify(dao, times(1)).findAll();
    }

	@Test
    public void createBookingTest()
    {
    	Customer emp = new Customer(1, "Sasmita", "Swain", "bookuser1@gmail.com", "user1@123");
         
        manager.saveCustomer(emp);
         
        verify(dao, times(1)).save(emp);
    }

	private CrudRepository<Customer, Integer> verify(BookingRepository dao2, Object times) {
		
				return null;
	}

	private Object times(int i) {
		
		return null;
	}
}
