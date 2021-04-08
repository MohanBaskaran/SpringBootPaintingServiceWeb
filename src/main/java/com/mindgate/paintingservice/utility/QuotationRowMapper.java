package com.mindgate.paintingservice.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mindgate.paintingservice.model.Quotation;

public class QuotationRowMapper implements RowMapper<Quotation> {

@Override
public Quotation mapRow(ResultSet rs, int rowNum) throws SQLException {
Quotation quotation =new Quotation();
/*quotation.setCustomerName(rs.getString("CUSTOMER_NAME"));
quotation.setAreaToPaint(rs.getInt(" PROPERTY_AREA_IN_SQFT"));
quotation.setCostEstimation(rs.getInt("APPROXIMATE_COST"));
quotation.setPaintColor("COLOR_NAME");*/
quotation.setCustomerId(rs.getString(1));
quotation.setCustomerName(rs.getString(2));
quotation.setAreaToPaintSqFt(rs.getInt(3));
quotation.setCostEstimation(rs.getInt(4));
quotation.setPaintColor(rs.getString(5));
return quotation;
}

}