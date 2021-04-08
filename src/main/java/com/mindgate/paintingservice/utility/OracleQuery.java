package com.mindgate.paintingservice.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mindgate.paintingservice.model.Customer;
import com.mindgate.paintingservice.model.Property;

public class OracleQuery {
	public static String registerBooking(Customer customer) throws ParseException {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into painting_service_customer(customer_name,customer_email_id,city,customer_address,mobile_number,registered_date,visited_date) values('");
		sb.append(customer.getCustomerName());
		sb.append("','");
		sb.append(customer.getCustomerEmailId());
		sb.append("','");
		sb.append(customer.getCustomerCity());
		sb.append("','");
		sb.append(customer.getCustomerAddress());
		sb.append("',");
		sb.append(customer.getCustomerPhone());
		sb.append(",TO_DATE('");
		sb.append(tosqlDateStr(customer.getRegisterDate()));
		sb.append("','DD/MM/YYYY'),TO_DATE('");
		sb.append(tosqlDateStr(customer.getVistingDate()));
		sb.append("','DD/MM/YYYY'))");
		return sb.toString();
	}

	public static String tosqlDateStr(java.sql.Date date) {
		String dateForSql = "";
		
		if (date == null) {
			dateForSql = null;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
			dateForSql = sdf.format(date);
		}

		return dateForSql;

	}
	public static String RegisterForProperty(Property property) 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("insert into property(property_age,property_area_in_sqFt,color,approximate_cost,CUSTOMER_ID) values(");
		sb.append(property.getPropertyAge());
		sb.append(",");
		sb.append(property.getPropertySqFt());
		sb.append(",'");
		sb.append(property.getColor());
		sb.append("',");
		sb.append(property.getPropertyCost());
		sb.append(",'");
		sb.append(property.getCustomerId());
		sb.append("')");
		return sb.toString();
	}

}
