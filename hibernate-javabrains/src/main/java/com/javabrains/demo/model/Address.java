package com.javabrains.demo.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
}
