package com.javabrains.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity	(name="USER_DETAILS")
@Data
@AllArgsConstructor
public class UserDetails {

	@Id
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String username;
}
