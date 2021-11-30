package com.javabrains.demo.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String username;
	@Temporal(TemporalType.DATE)
	private Date dateJoined;
	@Embedded
	private Address address;
	private String description;
	
	public UserDetails(String username, Date dateJoined, Address address, String description) {
		this.username = username;
		this.dateJoined = dateJoined;
		this.address = address;
		this.description = description;
	}
	
	
}
