package com.javabrains.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@OneToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;

	
	public UserDetails(String username, Vehicle vehicle) {
		this.username = username;
		this.vehicle = vehicle;
	}
	
	
}
