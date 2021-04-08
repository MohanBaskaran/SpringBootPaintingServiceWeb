package com.mindgate.paintingservice.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mindgate.paintingservice.model.Property;

public class ResultSetExtractorProperty implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Property> listofProperty = new ArrayList<Property>();
		while (rs.next()) {
			Property property = new Property();
			property.setCustomerId(rs.getString("CUSTOMER_ID"));
			property.setPropertyId(rs.getString("PROPERTY_ID"));
			property.setPropertyAge(rs.getInt("property_age"));
			property.setPropertySqFt(rs.getInt("property_area_in_sqFt"));
			property.setColor(rs.getString("color"));
			property.setPropertyCost(rs.getInt("approximate_cost"));

			listofProperty.add(property);
		}
		return listofProperty;
	}
}
