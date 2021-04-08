package com.mindgate.paintingservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindgate.paintingservice.PaintingServiceAppApplication;
import com.mindgate.paintingservice.configuration.DatabaseConfiguration;
import com.mindgate.paintingservice.dao.PaintingDaoImpl;
import com.mindgate.paintingservice.model.Customer;


//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)		
@RunWith(MockitoJUnitRunner.class)
//@ContextConfiguration(classes= {DatabaseConfiguration.class,PaintingServiceAppApplication.class})
//@SpringBootTest(classes=PaintingDaoImpl.class)
class PaintingServiceImplTestUsingMockObject 
{

	
	//@Autowired // real object is injected and invoking the methods
	
	@Autowired
	//@Mock
	private PaintingDaoImpl paintingDaoImpl;
	 
	@Autowired
	//@Mock
	Customer mockcustomer;
	
	//Autowired
	//@Mock
	//Customer customer;
	@Autowired
	@InjectMocks
	JdbcTemplate JdbcTemplate;
	@Before
    public void init() 
	{
        MockitoAnnotations.initMocks(this);
    }
		
	@Test
	void testRegisterCustomer() 
	{
		System.out.println("PaintingDaoImpl obj: "+paintingDaoImpl);
		System.out.println("customer obj: "+mockcustomer);
		System.out.println("customer obj: "+mockcustomer.hashCode());
		mockcustomer.setCustomerName("Arya");
		mockcustomer.setCustomerPhone(987661232);
		mockcustomer.setCustomerEmailId("Arya123@gmail.com");
		mockcustomer.setCustomerAddress("Nugampakkam"); 
		mockcustomer.setCustomerCity("CITY01");
		mockcustomer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		mockcustomer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		System.out.println("customer: "+mockcustomer);
		assertTrue(paintingDaoImpl.registerCustomer(mockcustomer));
	}

	/*@Test
	void testDisplayAllCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testRegistionBookingForProperty() {
		fail("Not yet implemented");
	}

	@Test
	void testDisplayAllProperty() {
		fail("Not yet implemented");
	}

	@Test
	void testGetQuotation() {
		fail("Not yet implemented");
	}

	@Test
	void testSupervisorLogin() {
		fail("Not yet implemented");
	}
	*/

}
