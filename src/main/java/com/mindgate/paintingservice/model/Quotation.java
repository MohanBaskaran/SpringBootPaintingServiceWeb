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
public class Quotation {
	private String customerId;
	private String customerName;
	private long areaToPaintSqFt;
	private String paintColor;
	private double costEstimation;

}