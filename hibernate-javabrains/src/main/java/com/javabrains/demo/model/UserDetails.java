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
	@Temporal(TemporalType.DATE)
	private Date dateJoined;
	@ElementCollection
	@GenericGenerator(name="myGenerator",strategy="sequence")
	@CollectionId(
	    columns=@Column(name="address"),
	    type=@Type(type="long"),
	    generator="myGenerator"
	)
	private Collection<Address> addresses= new ArrayList<Address>();
	private String description;
	@OneToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	
	public UserDetails(String username, Date dateJoined, Collection<Address> addresses, String description) {
		this.username = username;
		this.dateJoined = dateJoined;
		this.addresses = addresses;
		this.description = description;
	}
	
	
}
