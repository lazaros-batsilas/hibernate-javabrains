package com.javabrains.demo.model;

import java.util.Date;

import javax.persistence.Entity;
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

	@Id
	private int userId;
	private String username;
	@Temporal(TemporalType.DATE)
	private Date dateJoined;
	private String address;
	private String description;
}
