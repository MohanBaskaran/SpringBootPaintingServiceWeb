  package com.mindgate.paintingservice.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.paintingservice.model.Customer;

public class ResultSetExtractorImpl implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Customer> listofCustomer = new ArrayList<Customer>();
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("CUSTOMER_ID"));
			customer.setCustomerName(rs.getString("customer_name"));
			customer.setCustomerEmailId(rs.getString("customer_email_id"));
			customer.setCustomerCity(rs.getString("city"));
			customer.setCustomerAddress(rs.getString("customer_address"));
			customer.setCustomerPhone(rs.getLong("mobile_number"));
			customer.setRegisterDate(rs.getDate("registered_date"));
			customer.setVistingDate(rs.getDate("visited_date"));
			listofCustomer.add(customer);
		}
		return listofCustomer;
	}

	

}
