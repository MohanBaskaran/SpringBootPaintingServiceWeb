package com.mindgate.paintingservice.dao;

import java.util.List;

import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;
import com.mindgate.paintingservice.model.SupervisorLogin;

public interface PaintingDao {
	public boolean registerCustomer(Customer customer);
	List<Customer> displayAllCustomer();
	public boolean registionBookingForProperty(Property property);
	List<Property> displayAllProperty();
	public Quotation getQuotation(String CUSTOMER_ID);
	public SupervisorLogin supervisorLogin(String emailId, String password);

}
