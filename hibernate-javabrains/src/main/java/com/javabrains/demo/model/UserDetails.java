package com.javabrains.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id 	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String username;
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="user")
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	
	public UserDetails(String username, Collection<Vehicle> vehicles) {
		this.username = username;
		this.vehicles = vehicles;
	}
	
	
}
