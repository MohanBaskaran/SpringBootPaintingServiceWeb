package com.mindgate.paintingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;
import com.mindgate.paintingservice.model.SupervisorLogin;
import com.mindgate.paintingservice.service.PaintingServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class PaintingController {
	@Autowired
	private PaintingServiceImpl paintingServiceImpl;

	@GetMapping("/displayCustomer")
	public List<Customer> displayCustomer() {
		System.out.println("Hello");
		return paintingServiceImpl.displayAllCustomer();
	}

	@PostMapping("/registerCustomer")
	public HttpStatus RegisterCustomer(@RequestBody Customer customer) {
		System.out.println("----register Customer------"+customer.getCustomerName());
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		boolean status = paintingServiceImpl.registerCustomer(customer);
		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/displayProperty")
	public List<Property> displayProperty() {
		return paintingServiceImpl.displayAllProperty();
	}

	@PostMapping("/registerProperty")
	public HttpStatus RegisterProperty(@RequestBody Property property) {
		System.out.println("----register Property------"+property.getPropertyAge());
		boolean status = paintingServiceImpl.registionBookingForProperty(property);
		return status ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	//getQuotation/
	@GetMapping("getQuotation/{customer_id}")
	@ResponseBody
	public Quotation getQuotation(@PathVariable String customer_id)
	{
	System.out.println("inside controller");
	return paintingServiceImpl.getQuotation(customer_id);
	}
	
	@GetMapping("login/{emailId}{password}")
	@ResponseBody
	public SupervisorLogin loginSupervisor(@PathVariable String emailId,@PathVariable String password)
	{
	System.out.println("inside controller");
	return paintingServiceImpl.supervisorLogin(emailId,password);
	}
 
}
