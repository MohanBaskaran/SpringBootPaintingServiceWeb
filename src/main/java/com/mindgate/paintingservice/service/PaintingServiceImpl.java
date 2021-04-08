package com.mindgate.paintingservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.paintingservice.dao.PaintingDao;
import com.mindgate.paintingservice.dao.PaintingDaoImpl;
import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;
import com.mindgate.paintingservice.model.SupervisorLogin;

@Service
public class PaintingServiceImpl implements PaintingDao {

	@Autowired
	PaintingDaoImpl paintingDaoImpl;
	@Autowired
	Customer customer;
	@Autowired
	Quotation quotation;

	// Customer
	@Override
	public boolean registerCustomer(Customer customer) {
		
		System.out.println("inside service");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		return paintingDaoImpl.registerCustomer(customer);
	}
	// select * from property p ,customer c where c.propertyid=p.propertyid;

	@Override
	public List<Customer> displayAllCustomer() {
		return paintingDaoImpl.displayAllCustomer();
	}

	// Property
	@Override
	public boolean registionBookingForProperty(Property property) {

		return paintingDaoImpl.registionBookingForProperty(property);
	}

	@Override
	public List<Property> displayAllProperty() {
		return paintingDaoImpl.displayAllProperty();
	}

	public Quotation getQuotation(String customer_id) {
		return paintingDaoImpl.getQuotation(customer_id);
	}

	@Override
	public SupervisorLogin supervisorLogin(String emailId, String password) {
		
		return paintingDaoImpl.supervisorLogin(emailId,password);
	}
	}

