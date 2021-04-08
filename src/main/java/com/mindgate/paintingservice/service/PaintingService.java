package com.mindgate.paintingservice.service;

import java.util.List;

import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;

public interface PaintingService {
	
	List<Customer> displayAllCustomer();
	boolean registionBooking(Customer customer);
	boolean registionBookingForProperty(Property property);
	List<Property> displayAllProperty();
	public Quotation getQuotation(String customer_id);
//	public SupervisorLogin loginsupervisor(String supervisorId);
	
}
