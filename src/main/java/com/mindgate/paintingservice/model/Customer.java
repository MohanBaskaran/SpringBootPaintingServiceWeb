package com.mindgate.paintingservice.model;


import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	
	
	private String customerId;
	private String customerName;
	private String customerEmailId;
	private String customerCity;
	private String customerAddress;
	private long customerPhone;
	private Date registerDate;
	private Date vistingDate;
	
}
