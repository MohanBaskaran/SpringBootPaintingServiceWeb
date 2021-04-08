package com.mindgate.paintingservice.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;
import com.mindgate.paintingservice.model.Quotation;
import com.mindgate.paintingservice.model.SupervisorLogin;
import com.mindgate.paintingservice.utility.OracleQuery;
import com.mindgate.paintingservice.utility.QuotationRowMapper;
import com.mindgate.paintingservice.utility.ResultSetExtractorImpl;
import com.mindgate.paintingservice.utility.ResultSetExtractorProperty;

@Repository
public class PaintingDaoImpl implements PaintingDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	@Autowired
	Quotation quotation;
	@Autowired
	Property property;
	@Autowired
	SupervisorLogin supervisorLogin;

	// Customer
	@Override
	public boolean registerCustomer(Customer customer) {
		boolean status = false;
		if (customer.getCustomerName() != null && customer.getCustomerEmailId() != null
				&& customer.getCustomerCity() != null && customer.getCustomerAddress() != null) {

			int i;
			try {
				i = jdbctemplate.update(OracleQuery.registerBooking(customer));
				if (i > 0) {
					status = true;
				}

			} catch (DataAccessException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		return status;
	}
//select * from property p ,customer c where c.propertyid=p.propertyid;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> displayAllCustomer() {
//		String oracleQuery="select * from painting_service_customer where REGISTERED_DATE >=sysdate-1";
		String oracleQuery = "select * from painting_service_customer where REGISTERED_DATE >=sysdate-1";
		return (List<Customer>) jdbctemplate.query(oracleQuery, new ResultSetExtractorImpl());
	}

	// Property

	@Override
	public boolean registionBookingForProperty(Property property) {

		boolean status = false;
		if (property.getPropertyAge() > 0 && property.getColor() != null && property.getPropertyCost() > 0
				&& property.getPropertySqFt() > 0 && property.getCustomerId() != null) {
			int i;
			try {
				i = jdbctemplate.update(OracleQuery.RegisterForProperty(property));
				if (i > 0) {
					status = true;
				}

			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Property> displayAllProperty() {
		String oracleQuery = "select * from property";
		return (List<Property>) jdbctemplate.query(oracleQuery, new ResultSetExtractorProperty());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Quotation getQuotation(String customer_id) {
		String query = "select painting_service_customer.customer_id,painting_service_customer.customer_name,property.property_area_in_sqft,property.APPROXIMATE_COST,color.COLOR_NAME from property inner join color on property.color=color.COLOR_ID inner join painting_service_customer on painting_service_customer.customer_id=property.CUSTOMER_ID where property.CUSTOMER_ID=?";
		quotation = (Quotation) jdbctemplate.queryForObject(query, new Object[] { customer_id },
				new QuotationRowMapper());
		return quotation;
	} 

	@Override
	public SupervisorLogin supervisorLogin(String emailId, String password) {
		String query = "SELECT * FROM login WHERE emailId=? and  password=?";
		supervisorLogin = (SupervisorLogin) jdbctemplate.query(query, new ResultSetExtractorImpl());
		return supervisorLogin;
	}
	
}
