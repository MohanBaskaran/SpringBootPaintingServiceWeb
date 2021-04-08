package com.mindgate.paintingservice.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.mindgate.paintingservice.dao.PaintingDaoImpl;
import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest("Application.class")
class PaintingServiceImplTest {

	@Autowired
	private PaintingDaoImpl paintingDaoImpl;

	@Test
	void testRegisterBooking() {
		com.mindgate.paintingservice.model.Customer customer = new Customer();
		customer.setCustomerName("Aisha");
		customer.setCustomerPhone(987654321);
		customer.setCustomerEmailId("Aisha123@gmail.com");
		customer.setCustomerAddress("kodambakkam");
		customer.setCustomerCity("CITY01");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		assertTrue(paintingDaoImpl.registerCustomer(customer));

	}

	@Test
	void testRegisterBookingIfCustomerNameIsNull() {

		Customer customer = new Customer();
		// customer.setCustomerName("ravi");
		customer.setCustomerPhone(987654321);
		customer.setCustomerEmailId("ravi@gmail.com");
		customer.setCustomerAddress("Medavakkam");
		customer.setCustomerCity("CITY01");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		assertFalse(paintingDaoImpl.registerCustomer(customer));

	}

	@Test
	void testRegisterBookingIfCustomerEmailIdIsNull() {

		Customer customer = new Customer();
		customer.setCustomerName("ravi");
		customer.setCustomerPhone(987654321);
		// customer.setEmailId("ravi@gmail.com");
		customer.setCustomerAddress("Medavakkam");
		customer.setCustomerCity("CITY01");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		assertFalse(paintingDaoImpl.registerCustomer(customer));

	}

	@Test
	void testRegisterBookingIfCustomerAddressIsNull() {

		Customer customer = new Customer();
		customer.setCustomerName("ravi");
		customer.setCustomerPhone(987654321);
		customer.setCustomerEmailId("ravi@gmail.com");
		// customer.setAddress("Medavakkam");
		customer.setCustomerCity("CITY01");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		assertFalse(paintingDaoImpl.registerCustomer(customer));

	}

	@Test
	void testRegisterBookingIfCustomerCityIsNull() {

		Customer customer = new Customer();
		customer.setCustomerName("ravi");
		customer.setCustomerPhone(987654321);
		customer.setCustomerEmailId("ravi@gmail.com");
		customer.setCustomerAddress("Medavakkam");
		// customer.setCity("CITY01");
		customer.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
		customer.setVistingDate(Date.valueOf(java.time.LocalDate.now().plusDays(3)));
		assertFalse(paintingDaoImpl.registerCustomer(customer));

	}
	/*
	 * @Test void testRegistrationBookingForProperty() { Property property=new
	 * Property(); property.setCustomerId("CUS026"); property.setPropertyAge(11);
	 * property.setPropertyCost(1600*12); property.setPropertySqFt(1600);
	 * property.setColor("CLR09");
	 * assertTrue(paintingServiceDaoImpl.registrationBookingForProperty(property));
	 * 
	 * }
	 */

	@Test
	void testRegistrationBookingForPropertyIfCustomerIdIsNull() {
		Property property = new Property();
		// property.setCustomerId("CUS026");
		property.setPropertyAge(11);
		property.setPropertyCost(1600 * 12);
		property.setPropertySqFt(1600);
		property.setColor("CLR09");
		assertFalse(paintingDaoImpl.registionBookingForProperty(property));

	}

	@Test
	void testRegistrationBookingForPropertyIfPropertyAgeIsNull() {
		Property property = new Property();
		property.setCustomerId("CUS026");
		// property.setPropertyAge(11);
		property.setPropertyCost(1600 * 12);
		property.setPropertySqFt(1600);
		property.setColor("CLR09");
		assertFalse(paintingDaoImpl.registionBookingForProperty(property));

	}

	@Test
	void testRegistrationBookingForPropertyIfPropertyCostIsNull() {
		Property property = new Property();
		property.setCustomerId("CUS026");
		property.setPropertyAge(11);
		// property.setPropertyCost(1600*12);
		property.setPropertySqFt(1600);
		property.setColor("CLR09");
		assertFalse(paintingDaoImpl.registionBookingForProperty(property));

	}

	@Test
	void testRegistrationBookingForPropertyIfPropertySqFtIsNull() {
		Property property = new Property();
		property.setCustomerId("CUS026");
		property.setPropertyAge(11);
		property.setPropertyCost(1600 * 12);
		// property.setPropertySqFt(1600);
		property.setColor("CLR09");
		assertFalse(paintingDaoImpl.registionBookingForProperty(property));

	}

	@Test
	void testRegistrationBookingForPropertyIfPropertyColorIsNull() {
		Property property = new Property();
		property.setCustomerId("CUS026");
		property.setPropertyAge(11);
		property.setPropertyCost(1600 * 12);
		property.setPropertySqFt(1600);
		// property.setColor("CLR09");
		assertFalse(paintingDaoImpl.registionBookingForProperty(property));

	}

	@Test
	void testGetQuotation() {
		Quotation quoteActual = new Quotation();
		Quotation quoteExepected = new Quotation();
		quoteExepected = paintingDaoImpl.getQuotation("CUS01");
		System.out.println("Quotes Expected: " + quoteExepected);

		quoteActual.setCustomerName("Mohan");
		quoteActual.setAreaToPaintSqFt(800);
		quoteActual.setPaintColor("red");
		quoteActual.setCostEstimation(6400);
		assertEquals(quoteExepected.getCustomerName(), quoteActual.getCustomerName());
		assertEquals(quoteExepected.getPaintColor(), quoteActual.getPaintColor());
		assertEquals(quoteExepected.getAreaToPaintSqFt(), quoteActual.getAreaToPaintSqFt());
		assertEquals(quoteExepected.getCostEstimation(), quoteActual.getCostEstimation(), 0.01);
	}

	@Test
	void testGetQuotationCheckCustomerNameIsIncorrect() {

		Quotation quoteExepected = new Quotation();
		quoteExepected = paintingDaoImpl.getQuotation("CUS01");
		System.out.println("Quotes Expected: " + quoteExepected);
		assertNotEquals(quoteExepected.getCustomerName(), "MOHAN");
		assertNotEquals(quoteExepected.getCustomerName(), "mOHAN");
		assertNotEquals(quoteExepected.getCustomerName(), "Clara");
	}

	@Test
	void testGetQuotationCheckPaintColorIsIncorrect() {

		Quotation quoteExepected = new Quotation();
		quoteExepected = paintingDaoImpl.getQuotation("CUS01");
		System.out.println("Quotes Expected: " + quoteExepected);
		assertNotEquals(quoteExepected.getPaintColor(), "blue");

	}

	@Test
	void testGetQuotationCheckAreaToPaintIsIncorrect() {

		Quotation quoteExepected = new Quotation();
		quoteExepected = paintingDaoImpl.getQuotation("CUS01");
		System.out.println("Quotes Expected: " + quoteExepected);
		assertNotEquals(quoteExepected.getAreaToPaintSqFt(), 80);

	}

	@Test
	void testGetQuotationCheckCostEstimationIsIncorrect() {

		Quotation quoteExepected = new Quotation();
		quoteExepected = paintingDaoImpl.getQuotation("CUS01");
		assertNotEquals(quoteExepected.getCostEstimation(), 6500.0);

	}

}
