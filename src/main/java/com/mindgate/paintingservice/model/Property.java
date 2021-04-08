package com.mindgate.paintingservice.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
	String customerId;
	String propertyId;
	int propertyAge;
	int propertySqFt;
	String color;
	int propertyCost;

}
